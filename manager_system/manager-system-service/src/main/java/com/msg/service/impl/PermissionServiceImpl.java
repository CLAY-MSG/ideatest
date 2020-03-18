package com.msg.service.impl;

import com.msg.dao.PermissionDao;
import com.msg.dao.RoleDao;
import com.msg.domain.Permission;
import com.msg.domain.Role;
import com.msg.service.PermissionService;
import com.msg.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/12 17:41
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    @Override
    public List<Permission> findOtherPermissionByRoleId(String id) {
        return permissionDao.findOtherPermissionByRoleId(id);
    }
}
