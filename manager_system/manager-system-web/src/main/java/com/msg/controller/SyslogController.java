package com.msg.controller;

import com.msg.domain.Syslog;
import com.msg.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/13 0:10
 */
@Controller
@RequestMapping("/syslog")
public class SyslogController {

    @Autowired
    private SyslogService syslogService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Syslog> syslogList = syslogService.findAll();
        model.addAttribute("syslogList",syslogList);
        return "syslog-list";
    }
}
