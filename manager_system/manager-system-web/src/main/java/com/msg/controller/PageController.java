package com.msg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/10 15:24
 */
@Controller
@RequestMapping("/pages")
public class PageController {

    @RequestMapping("/product-add")
    public String toProductAdd(){
        return "product-add";
    }

    @RequestMapping("/user-add")
    public String toUserAdd(){
        return "user-add";
    }

    @RequestMapping("/role-add")
    public String toRoleAdd(){
        return "role-add";
    }

    @RequestMapping("/permission-add")
    public String toPermissionAdd(){
        return "permission-add";
    }
}
