package com.msg.service;

import com.msg.domain.Orders;
import com.msg.domain.Users;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/11 11:10
 */
public interface UserService extends UserDetailsService {

    List<Users> findAll();

    void save(Users users) throws Exception;

    Users findById(String id) throws Exception;

    void addRoleToUser(String userId, String[] ids);
}
