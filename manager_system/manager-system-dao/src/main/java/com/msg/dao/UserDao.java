package com.msg.dao;

import com.msg.domain.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/11 19:17
 */
@Repository
public interface UserDao {

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true,property = "id", column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.msg.dao.RoleDao.findRolesByUserId")),
    })
    public Users findById(String id) throws Exception;

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true,property = "id", column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.msg.dao.RoleDao.findRolesByUserId")),
    })
    Users findUserByUsername(String username);

    @Select("select * from users")
    List<Users> findAll();

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(Users users) throws Exception;

    @Insert("insert into users_role values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
