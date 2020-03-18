package cn.msg.dao;

import cn.msg.domain.Department;
import cn.msg.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/27 21:30
 */
@Repository
public interface RoleDao {

    /**
     * 查询所有角色
     * @return
     */
    @Select("select * from role")
    public List<Role> findAllRole();

    /**
     * 添加角色
     * @param roleName
     * @param roleDesc
     * @return
     */
    @Insert("insert into role(roleName, roleDesc) values (#{roleName},#{roleDesc})")
    boolean addRole(@Param("roleName") String roleName, @Param("roleDesc") String roleDesc);

    /**
     * 删除角色
     * @param roleName
     */
    @Delete("delete from role where roleName = #{roleName}")
    void deleteRole(@Param("roleName") String roleName);

    /**
     * 修改角色
     * @param role
     * @return
     */
    @Update("UPDATE role SET roleName = #{roleName}, roleDesc = #{roleDesc}  WHERE rId = #{rId}")
    boolean updateRole(Role role);
}
