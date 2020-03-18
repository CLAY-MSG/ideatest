package cn.msg.service;

import cn.msg.domain.Department;
import cn.msg.domain.Role;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/23 23:38
 */
public interface RoleService {
    /**
     * 查询所有角色信息
     * @return
     */
    public List<Role> findAllRole();

    /**
     * 添加角色
     * @param roleName
     * @param roleDesc
     * @return
     */
    boolean addRole(String roleName, String roleDesc);

    /**
     * 删除角色
     * @param roleName
     */
    void deleteRole(String roleName);

    /**
     * 修改角色
     * @param role
     * @return
     */
    boolean updateRole(Role role);
}
