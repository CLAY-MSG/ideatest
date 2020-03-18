package com.itcast.dao;

import com.itcast.domain.LoginUser;
import com.itcast.domain.User;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/7 22:49
 */
public interface UserDao {
    /**
     * 登录
     * @param loginUser
     */
    public Boolean login(LoginUser loginUser);
    /**
     * 查询所有联系人信息
     * @return
     */
    public List<User> findAll();

    /**
     * 添加联系人
     * @param newUser
     */
    public void addUser(User newUser);
    /**
     * 根据userIdcha查找联系人
     * @param userId
     */
    public User findUserById(int userId);

    /**
     * 修改联系人
     * @param updateUser
     */
    public void updateUser(User updateUser);
    /**
     * 删除联系人
     * @param delUserId
     */
    public void delUser(int delUserId);

    /**
     * 分页查询
     * @return
     */
    List<User> findUserByPage(int start, int rows);

    /**
     * 得到总记录数
     * @return
     */
    int getTotalCount();
}
