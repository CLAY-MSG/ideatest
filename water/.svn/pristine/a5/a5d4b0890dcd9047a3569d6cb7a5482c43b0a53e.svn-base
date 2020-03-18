package cn.msg.service.impl;

import cn.msg.dao.RoleDao;
import cn.msg.domain.Role;
import cn.msg.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/28 21:20
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAllRole() {
        return roleDao.findAllRole();
    }

    @Override
    public boolean addRole(String roleName, String roleDesc) {
        return roleDao.addRole(roleName,roleDesc);
    }

    @Override
    public void deleteRole(String roleName) {
        roleDao.deleteRole(roleName);
    }

    @Override
    public boolean updateRole(Role role) {
        return roleDao.updateRole(role);
    }
}
