package com.itcast.service.impl;

import com.itcast.dao.UserDao;
import com.itcast.dao.impl.UserDaoImpl;
import com.itcast.domain.LoginUser;
import com.itcast.domain.PageBean;
import com.itcast.domain.User;
import com.itcast.service.UserService;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/7 23:27
 */
public class UserServiceImpl implements UserService {
    private UserDao ud = new UserDaoImpl();

    @Override
    public Boolean login(LoginUser loginUser) {
        return ud.login(loginUser);
    }

    @Override
    public List<User> findAll() {
        List<User> users = ud.findAll();
        return users;
    }

    @Override
    public void addUser(User newUser) {
        ud.addUser(newUser);
    }

    @Override
    public User findUserById(int userId) {
        return ud.findUserById(userId);
    }

    @Override
    public void updateUser(User updateUser){
        ud.updateUser(updateUser);
    }

    @Override
    public void delUser(int delUserId) {
        ud.delUser(delUserId);
    }

    @Override
    public void delSelectedUser(String[] delSelectedId) {
        for (String str : delSelectedId) {
            int i = Integer.parseInt(str);
            ud.delUser(i);
        }
    }

    @Override
    public int getTotalCount() {
        return ud.getTotalCount();
    }

    @Override
    public PageBean<User> findUserByPage(String currentPage, String rowS) {
        int start = Integer.parseInt(currentPage);
        int rows = Integer.parseInt(rowS);
        if(start <=0) {
            start = 1;
        }
        start = (start-1)*rows;
        List<User> userByPageList = ud.findUserByPage(start, rows);
        System.out.println(userByPageList);
        int totalCount = ud.getTotalCount();
        int totalPage = totalCount % rows == 0 ? totalCount/rows:(totalCount/rows)+1;
        PageBean<User> upb = new PageBean<>(totalCount,totalPage,rows,start,userByPageList);
        return upb;
    }


}
