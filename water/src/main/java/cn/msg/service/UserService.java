package cn.msg.service;

import cn.msg.dao.UserDao;
import cn.msg.domain.Department;
import cn.msg.domain.PageBean;
import cn.msg.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/23 23:38
 */
public interface UserService {
    /**
     * 登录校验
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 在线人数列表查询
     * @param start
     * @param pageSize
     * @return
     */
    public PageBean<User> findAllOnline(int start, int pageSize);

    /**
     * 查询所有用户信息
     * @return
     */
    public PageBean<User> findAllUser(int start, int pageSize);

    /**
     * 删除用户
     * @param uId
     */
    public void deleteUser(int uId);

    /**
     * 修改用户
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 新建用户
     * @param user
     * @return
     */
    boolean addUser(User user);
}
