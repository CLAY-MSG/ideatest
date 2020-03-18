package cn.msg.test;

import cn.msg.dao.UserDao;
import cn.msg.domain.User;
import cn.msg.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/25 17:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestUserDao {
    @Autowired
    private UserDao userDao;
    @Test
    public void testFindByUsernameAndPassword() throws IOException {
        User user = userDao.findByUsernameAndPassword("root",null);
        System.out.println(user);

    }
    @Test
    public void testFindAllOnline() throws IOException {
        List<User> user = userDao.findAllOnline(0,5);
        System.out.println(user);
    }
    @Test
    public void testFindTotalCount() throws IOException {
        Integer user = userDao.findTotalOnlineCount();
        System.out.println(user);
    }

    @Test
    public void testFindAllUser() throws IOException {
        List<User> allUser = userDao.findAllUser(1,5);
        System.out.println(allUser);
    }
    @Test
    public void testDeleteUser() throws IOException {
//       userDao.deleteUser(26);
        System.out.println(userDao.findOneUser(10));
    }
    @Test
    public void testUpdateUser() throws IOException {
        User user = new User();
        user.setuId(23);
        user.setUsername("mogutou");
        user.setName("蘑菇头");
        user.setSex("男");
        user.setTelephone("18965236485");
        user.setEmail("mogutou@qq.com");
        user.setUserDesc("asdasdasd");
        user.setDepartmentName("客服部");
        user.setRoleName("客服部成员");
        userDao.updateUser(user);
    }
    @Test
    public void testAddUser() throws IOException {
        User user = new User();
        user.setUsername("mogutou");
        user.setName("蘑菇头");
        user.setSex("男");
        user.setTelephone("18965236485");
        user.setEmail("mogutou@qq.com");
        user.setUserDesc("asdasdasd");
        user.setDepartmentName("客服部");
        user.setRoleName("客服部成员");
        userDao.addUser(user);
    }
}
