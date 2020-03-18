package com.msg.dao;

import com.msg.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/11 19:22
 */
@Repository
public interface RoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions" , column = "id" , javaType = java.util.List.class,many = @Many(select = "com.msg.dao.PermissionDao.findPermissionByRoleId"))
    })
    List<Role> findRolesByUserId(String userId);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id not in (select roleId from users_role where userId = #{id})")
    List<Role> findOtherRoleByUserId(String id);

    @Select("select * from role where id = #{id}")
    Role findById(String id);

    @Insert("insert into role_permission(roleId,permissionid) values (#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId);
}
