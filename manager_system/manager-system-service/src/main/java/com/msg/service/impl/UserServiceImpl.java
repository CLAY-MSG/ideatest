package com.msg.service.impl;

import com.msg.dao.UserDao;
import com.msg.domain.Role;
import com.msg.domain.Users;
import com.msg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/11 19:11
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users userByUsername = userDao.findUserByUsername(username);
        return new User(userByUsername.getUsername(),userByUsername.getPassword(), userByUsername.getStatus() == 1,true,true,true,getAuthority(userByUsername.getRoles()));
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            String roleName = "ROLE_"+role.getRoleName();
            authorities.add(new SimpleGrantedAuthority(roleName));
        }
        return authorities;
    }

    @Override
    public List<Users> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(Users users) throws Exception {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        userDao.save(users);
    }

    @Override
    public Users findById(String id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] ids) {
        for (String roleId : ids) {
            userDao.addRoleToUser(userId,roleId);
        }
    }
}
