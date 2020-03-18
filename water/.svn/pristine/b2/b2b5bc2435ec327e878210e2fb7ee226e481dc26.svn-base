package cn.msg.controller;

import cn.msg.domain.Department;
import cn.msg.domain.News;
import cn.msg.domain.Role;
import cn.msg.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/25 21:07
 */
@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/header")
    public String header(){
        return "header";
    }
    @RequestMapping("/lefter")
    public String lefter(){
        return "lefter";
    }
    @RequestMapping("/department")
    public String department(){
        return "department";
    }
    @RequestMapping("/adddepartment")
    public String adddepartment(){
        return "adddepartment";
    }
    @RequestMapping("/updatedepartment")
    public String updatedepartment(Integer dId,String departmentName,String departmentDesc,Model model){
        Department department = new Department();
        department.setdId(dId);
        department.setDepartmentName(departmentName);
        department.setDepartmentDesc(departmentDesc);
        model.addAttribute("department",department);
        return "updatedepartment";
    }
    @RequestMapping("/role")
    public String role(){
        return "role";
    }
    @RequestMapping("/addrole")
    public String addrole(){
        return "addrole";
    }

    @RequestMapping("/updaterole")
    public String updaterole(Integer rId,String roleName,String roleDesc,Model model){
        Role role = new Role();
        role.setrId(rId);
        role.setRoleName(roleName);
        role.setRoleDesc(roleDesc);
        model.addAttribute("role",role);
        return "updaterole";
    }

    @RequestMapping("/user")
    public String user(){
        return "user";
    }

    @RequestMapping("/updateuser")
    public String updateuser(@RequestBody User user, Model model){
        model.addAttribute("user",user);
        return "updateuser";
    }

    @RequestMapping("/adduser")
    public String addUser(){
        return "adduser";
    }

    @RequestMapping("/news")
    public String news(){
        return "news";
    }

    @RequestMapping("/updatenews")
    public String updatenews(@RequestBody News news, Model model){
        model.addAttribute("news",news);
        return "updatenews";
    }

    @RequestMapping("/addnews")
    public String addNews(){
        return "addnews";
    }
}
