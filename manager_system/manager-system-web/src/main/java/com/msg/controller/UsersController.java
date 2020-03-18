package com.msg.controller;

import com.msg.domain.Role;
import com.msg.domain.Users;
import com.msg.service.RoleService;
import com.msg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/9 14:33
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Users> usersList = userService.findAll();
        model.addAttribute("usersList",usersList);
        return "user-list";
    }

    @RequestMapping("/save")
    public String save(Users users) throws Exception {
        userService.save(users);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public String findById(Model model, String id) throws Exception {
        Users users = userService.findById(id);
        model.addAttribute("users",users);
        return "user-show";
    }
    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(Model model, String id) throws Exception {
        Users users = userService.findById(id);
        List<Role> roleList = roleService.findOtherRoleByUserId(id);
        model.addAttribute("users",users);
        model.addAttribute("roleList",roleList);
        return "user-role-add";
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId, @RequestParam(name = "ids",required = true) String[] ids) throws Exception {
        userService.addRoleToUser(userId,ids);
        return "redirect:findAll";
    }


}
