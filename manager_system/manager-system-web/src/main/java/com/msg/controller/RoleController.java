package com.msg.controller;

import com.msg.domain.Permission;
import com.msg.domain.Role;
import com.msg.domain.Users;
import com.msg.service.PermissionService;
import com.msg.service.RoleService;
import com.msg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/9 14:33
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;

    @RequestMapping("/findAll")
    @RolesAllowed("ADMIN")
    public String findAll(Model model){
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList",roleList);
        return "role-list";
    }

    @RequestMapping("/save")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll";
    }

    @RequestMapping("/findRoleByIdAndAllPermission")
    public String findRoleByIdAndAllPermission(Model model,String id) throws Exception {
        Role role = roleService.findById(id);
        List<Permission> permissionList = permissionService.findOtherPermissionByRoleId(id);
        model.addAttribute("role",role);
        model.addAttribute("permissionList",permissionList);
        return "role-permission-add";
    }

    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) String roleId, @RequestParam(name = "ids",required = true) String[] ids) throws Exception {
        roleService.addPermissionToRole(roleId,ids);
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
