package com.itcast.dao.impl;

import com.itcast.dao.UserDao;
import com.itcast.domain.LoginUser;
import com.itcast.domain.User;
import com.itcast.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/7 23:16
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getMysqlDataSource());

    @Override
    public Boolean login(LoginUser loginUser) {
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        String sql = "select * from loginuser where username = ? and password = ?";
        List<LoginUser> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LoginUser.class), username, password);
        if (query.size()==1){
            return true;
        }
        return false;
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;

    }

    /**
     * 添加用户
     * @param newUser
     */
    @Override
    public void addUser(User newUser) {
        String username = newUser.getUsername();
        String gender = newUser.getGender();
        int age = newUser.getAge();
        String address = newUser.getAddress();
        int qq = newUser.getQq();
        String email = newUser.getEmail();
        String sql = "insert user(username, gender, age, address, qq, email) values (?,?,?,?,?,?)";
        jdbcTemplate.update(sql,username,gender,age,address,qq,email);
    }

    @Override
    public User findUserById(int userId) {
        String sql = "select * from user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), userId);
        return user;
    }

    @Override
    public void updateUser(User updateUser) {
        int id = updateUser.getId();
        String username = updateUser.getUsername();
        String gender = updateUser.getGender();
        int age = updateUser.getAge();
        String address = updateUser.getAddress();
        int qq = updateUser.getQq();
        String email = updateUser.getEmail();
        String sql = "update user set username = ?,gender = ?,age = ?, address = ?, qq = ? , email = ? where id = ?";
        jdbcTemplate.update(sql,username,gender,age,address,qq,email,id);
    }

    @Override
    public void delUser(int delUserId) {
        String sql = "delete FROM user where id = ?";
        jdbcTemplate.update(sql,delUserId);
    }

    @Override
    public int getTotalCount() {
        String totalCountSql = "select count(*) from user";
        return jdbcTemplate.queryForObject(totalCountSql,Integer.class);
    }


    @Override
    public List<User> findUserByPage(int start, int rows) {
        String sql = "select * from user limit ?,?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), start, rows);
    }


}
