package cn.msg.dao;

import cn.msg.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/23 23:37
 */
@Repository
public interface UserDao {
    /**
     * 查询总在线人数
     * @return
     */
    @Select("select count(*) from user where sid != (select id from status where statu = '离线')")
    public Integer findTotalOnlineCount();

    /**
     * 查询每页显示内容
     * @param start
     * @param pageSize
     * @return
     */
    @Select( "select uId,username,password,name,sex,telephone,email,userDesc,statu,roleName ,departmentName from user,status,department,role where user.sId=status.id and user.rId = role.rId and user.dId = department.dId and sid <> (select id from status where statu = '离线') limit #{start},#{pageSize}")
    public List<User> findAllOnline(@Param("start") int start, @Param("pageSize") int pageSize);

    /**
     * 根据账号密码查询用户
     * @param username
     * @param password
     * @return
     */
    @Select( "select * from user where username = #{username} and password = #{password}")
    public User findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);

    /**
     * 查询总人数
     * @return
     */
    @Select("select count(*) from user")
    public Integer findTotalUserCount();

    /**
     * 查询每页显示内容
     * @param start
     * @param pageSize
     * @return
     */
    @Select( "select uId,username,password,name,sex,telephone,email,userDesc,statu,roleName ,departmentName from user,status,department,role where user.sId=status.id and user.rId = role.rId and user.dId = department.dId limit #{start},#{pageSize}")
    public List<User> findAllUser(@Param("start") int start, @Param("pageSize") int pageSize);

    /**
     * 删除用户
     * @param uId
     */
    @Delete("delete from user where uId = #{uId}")
    void deleteUser(int uId);

    /**
     * 修改用户
     * @param user
     * @return
     */
    @Update("UPDATE user SET username = #{username},name = #{name}, sex = #{sex},telephone = #{telephone}, email = #{email},userDesc = #{userDesc},dId = (select dId from department where departmentName = #{departmentName}),rId = (select rId from role where roleName = #{roleName})  WHERE uId = #{uId}")
    boolean updateUser(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Insert("insert into user(username,name,sex,telephone,email,userDesc,dId,rId) values (#{username},#{name},#{sex},#{telephone},#{email},#{userDesc},(select dId from department where departmentName = #{departmentName}),(select rId from role where roleName = #{roleName}))")
    boolean addUser(User user);

    /**
     * 查找一个用户
     * @param uId
     * @return
     */
    @Select("select uId,username,password,name,sex,telephone,email,userDesc,statu,roleName ,departmentName from user,status,department,role where user.sId=status.id and user.rId = role.rId and user.dId = department.dId and uId = #{uId}")
    User findOneUser(Integer uId);
}
