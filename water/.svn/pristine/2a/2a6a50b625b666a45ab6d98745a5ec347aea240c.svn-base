package cn.msg.test;

import cn.msg.domain.User;
import cn.msg.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/25 16:26
 */
public class TestUserService {

    @Test
    public void testLogin(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.login(new User());
    }
}
