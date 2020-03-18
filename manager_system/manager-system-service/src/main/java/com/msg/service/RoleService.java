package com.msg.service;

import com.msg.domain.Role;
import com.msg.domain.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/11 11:10
 */
public interface RoleService {

    List<Role> findAll();

    void save(Role role);

    List<Role> findOtherRoleByUserId(String id);

    Role findById(String id);

    void addPermissionToRole(String roleId, String[] ids);
}
