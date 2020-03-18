package com.msg.controller;

import com.msg.domain.Permission;
import com.msg.domain.Role;
import com.msg.service.PermissionService;
import com.msg.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/9 14:33
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @RequestMapping("/findAll")
    @PostAuthorize("authentication.principal.username=='hanhan'")
    public String findAll(Model model){
        List<Permission> permissionList = permissionService.findAll();
        model.addAttribute("permissionList",permissionList);
        return "permission-list";
    }

    @RequestMapping("/save")
    @PostAuthorize("hasRole('ROLE_ADMIN')")
    public String save(Permission permission) throws Exception {
        permissionService.save(permission);
        return "redirect:findAll";
    }

   /* @RequestMapping("/findById")
    public String findById(Model model, String id) throws Exception {
        Users users = userService.findById(id);
        model.addAttribute("users",users);
        return "user-show";
    }
*/



}
