package com.msg.controller;

import com.msg.domain.Syslog;
import com.msg.service.SyslogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/12 23:25
 */
@Component
@Aspect
@SuppressWarnings("unchecked")
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SyslogService syslogService;

    private Date visitTime;
    private Class clazz;
    private Method method;

    /**
     * 主要获取访问时间、访问的类、访问的方法
     *
     * @param joinPoint
     * @throws Exception
     */
    @Before("execution(* com.msg.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        //获取访问时间
        visitTime = new Date();

        //获取访问的类
        clazz = joinPoint.getTarget().getClass();

        //获取访问的方法
        String methodName = joinPoint.getSignature().getName();

        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName);
        } else {
            Class[] argsClasses = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof BindingAwareModelMap){
                    argsClasses[i] = Model.class;
                    continue;
                }
                argsClasses[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, argsClasses);
        }

    }

    /**
     * 主要获取日志中其它信息，时长、ip、url...
     *
     * @param joinPoint
     */
    @After("execution(* com.msg.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) {

        //获取操作者用户名
        SecurityContext securityContext = SecurityContextHolder.getContext();
        User user = (User) securityContext.getAuthentication().getPrincipal();
        String username = user.getUsername();

        //获取访问的URL
        if (clazz != SyslogController.class) {
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String url = classAnnotation.value()[0] + methodAnnotation.value()[0];

                    //获取访问时长
                    Long executionTime = System.currentTimeMillis() - visitTime.getTime();

                    //获取访问IP

                    String ip = request.getRemoteAddr();

                    //封装Syslog对象
                    Syslog syslog = new Syslog();
                    syslog.setExecutionTime(executionTime);
                    syslog.setVisitTime(visitTime);
                    syslog.setMethod("[类名]" + clazz.getName() + "[方法名]" + method.getName());
                    syslog.setUrl(url);
                    syslog.setUsername(username);
                    syslog.setIp(ip);

                    syslogService.save(syslog);

                }
            }

        }
    }
}
