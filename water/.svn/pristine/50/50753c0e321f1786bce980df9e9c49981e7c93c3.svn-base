package cn.msg.controller;

import cn.msg.domain.Department;
import cn.msg.domain.PageBean;
import cn.msg.domain.ResultInfo;
import cn.msg.domain.User;
import cn.msg.service.DepartmentService;
import cn.msg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/23 22:39
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/departmentList")
    public @ResponseBody List<Department> findAllDepartment(){
        return departmentService.findAllDepartment();
    }
    @RequestMapping("/addDepartment")
    public @ResponseBody ResultInfo addDepartment(String departmentName,String departmentDesc){
        boolean flag = departmentService.addDepartment(departmentName,departmentDesc);
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
    @RequestMapping("/deleteDepartment")
    public @ResponseBody String deleteDepartment(String departmentName){
        departmentService.deleteDepartment(departmentName);
        return "删除成功";
    }

    @RequestMapping("/updateDepartment")
    public @ResponseBody ResultInfo updateDepartment(Department department){
        boolean flag = departmentService.updateDepartment(department);
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
