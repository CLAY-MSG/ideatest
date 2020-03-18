package cn.msg.controller;

import cn.msg.domain.Department;
import cn.msg.domain.ResultInfo;
import cn.msg.domain.Role;
import cn.msg.service.DepartmentService;
import cn.msg.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/23 22:39
 */
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/roleList")
    public @ResponseBody List<Role> findAllDepartment(){
        return roleService.findAllRole();
    }

    @RequestMapping("/addRole")
    public @ResponseBody ResultInfo addDepartment(String roleName,String roleDesc){
        boolean flag = roleService.addRole(roleName, roleDesc);
        ResultInfo resultInfo = new ResultInfo();
        if (flag){
            resultInfo.setFlag(true);
            resultInfo.setData("保存成功");
        }else {
            resultInfo.setFlag(false);
            resultInfo.setData("保存失败，请重新尝试");
        }
        return resultInfo;
    }
    @RequestMapping("/deleteRole")
    public @ResponseBody String deleteRole(String roleName){
        roleService.deleteRole(roleName);
        return "删除成功";
    }

    @RequestMapping("/updateRole")
    public @ResponseBody ResultInfo updateRole(Role role){
        boolean flag = roleService.updateRole(role);
        ResultInfo resultInfo = new ResultInfo();
        if (flag){
            resultInfo.setFlag(true);
            resultInfo.setData("保存成功");
        }else {
            resultInfo.setFlag(false);
            resultInfo.setData("保存失败，请重新尝试");
        }
        return resultInfo;
    }
}
