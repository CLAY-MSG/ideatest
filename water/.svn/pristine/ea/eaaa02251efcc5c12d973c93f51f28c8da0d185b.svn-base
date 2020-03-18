package cn.msg.controller;

import cn.msg.domain.Department;
import cn.msg.domain.PageBean;
import cn.msg.domain.ResultInfo;
import cn.msg.domain.User;
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
@RequestMapping("/user")
@SessionAttributes(value = {"loginUser"},types = {User.class})
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public @ResponseBody ResultInfo login(User loginU, Model model){
        User loginUser = userService.login(loginU);
        ResultInfo resultInfo = new ResultInfo();
        if (loginUser==null){
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("用户名密码或错误");
        }
        if (loginUser!=null){
            model.addAttribute("loginUser",loginUser);
            resultInfo.setFlag(true);
        }
        return resultInfo;
    }

    @RequestMapping("/online")
    public @ResponseBody PageBean<User> findAllOnline(String currentPage,String pageSize){
        int currentPageInt = 0;
        if (currentPage != null && currentPage.length() != 0) {
            currentPageInt = Integer.parseInt(currentPage);
        } else {
            currentPageInt = 1;
        }
        int pageSizeInt = 0;
        if (pageSize != null && pageSize.length() != 0) {
            pageSizeInt = Integer.parseInt(pageSize);
        } else {
            pageSizeInt = 5;
        }
        return userService.findAllOnline(currentPageInt, pageSizeInt);
    }

    @RequestMapping("/userList")
    public @ResponseBody PageBean<User> findAllUser(String currentPage,String pageSize){
        int currentPageInt;
        if (currentPage != null && currentPage.length() != 0) {
            currentPageInt = Integer.parseInt(currentPage);
        } else {
            currentPageInt = 1;
        }
        int pageSizeInt;
        if (pageSize != null && pageSize.length() != 0) {
            pageSizeInt = Integer.parseInt(pageSize);
        } else {
            pageSizeInt = 5;
        }
        return userService.findAllUser(currentPageInt, pageSizeInt);
    }
    @RequestMapping("/deleteUser")
    public @ResponseBody String deleteUser(String uId){
        userService.deleteUser(Integer.parseInt(uId));
        return "删除成功";
    }

    @RequestMapping("/updateUser")
    public @ResponseBody ResultInfo updateDepartment(User user){
        boolean flag = userService.updateUser(user);
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
    @RequestMapping("/addUser")
    public @ResponseBody ResultInfo addUser(User user){
        boolean flag = userService.addUser(user);
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
