package com.msg.service;

import com.msg.domain.Permission;
import com.msg.domain.Role;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/11 11:10
 */
public interface PermissionService {

    List<Permission> findAll();

    void save(Permission permission);

    List<Permission> findOtherPermissionByRoleId(String id);
}
