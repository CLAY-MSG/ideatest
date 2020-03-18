package com.msg.service.impl;

import com.msg.dao.RoleDao;
import com.msg.domain.Role;
import com.msg.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/12 17:41
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Role> findOtherRoleByUserId(String id) {
        return roleDao.findOtherRoleByUserId(id);
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) {
        for (String permissionId : ids) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
