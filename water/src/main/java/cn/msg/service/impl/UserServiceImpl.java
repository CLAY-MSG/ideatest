package cn.msg.service.impl;

import cn.msg.dao.UserDao;
import cn.msg.domain.Department;
import cn.msg.domain.PageBean;
import cn.msg.domain.User;
import cn.msg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/23 23:38
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public PageBean<User>  findAllOnline(int currentPage, int pageSize) {
        PageBean<User> userPageBean = new PageBean<User>();
        Integer totalOnlineCount = userDao.findTotalOnlineCount();
        userPageBean.setTotalCount(totalOnlineCount);
        userPageBean.setCurrentPage(currentPage);
        userPageBean.setPageSize(pageSize);
        int totalPage = totalOnlineCount % pageSize == 0 ? totalOnlineCount/pageSize : (totalOnlineCount/pageSize)+1;
        userPageBean.setTotalPage(totalPage);
        int start = (currentPage-1)*pageSize;
        List<User> userList = userDao.findAllOnline(start, pageSize);
        userPageBean.setPageContent(userList);
        return userPageBean;
    }

    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public PageBean<User> findAllUser(int currentPage, int pageSize) {
        PageBean<User> userPageBean = new PageBean<User>();
        Integer totalUserCount = userDao.findTotalUserCount();
        userPageBean.setTotalCount(totalUserCount);
        userPageBean.setCurrentPage(currentPage);
        userPageBean.setPageSize(pageSize);
        int totalPage = totalUserCount % pageSize == 0 ? totalUserCount/pageSize : (totalUserCount/pageSize)+1;
        userPageBean.setTotalPage(totalPage);
        int start = (currentPage-1)*pageSize;
        System.out.println(start);
        List<User> userList = userDao.findAllUser(start, pageSize);
        userPageBean.setPageContent(userList);
        System.out.println(userList);
        return userPageBean;
    }

    @Override
    public void deleteUser(int uId) {
        userDao.deleteUser(uId);
    }

    @Override
    public boolean updateUser(User user) {
//        Department oldDepartment = departmentDao.findOneDepartment(department.getdId());
        return userDao.updateUser(user);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }
}
