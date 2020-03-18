package com.msg.dao;

import com.msg.domain.Permission;
import com.msg.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.beans.PersistenceDelegate;
import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/11 19:22
 */
@Repository
public interface PermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findPermissionByRoleId(String roleId);

    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission(permissionName,url) values (#{permissionName},#{url})")
    void save(Permission permission);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{id})")
    List<Permission> findOtherPermissionByRoleId(String id);
}
