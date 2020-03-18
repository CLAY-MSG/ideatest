package cn.msg.test;

import cn.msg.dao.DepartmentDao;
import cn.msg.dao.UserDao;
import cn.msg.domain.Department;
import cn.msg.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/25 17:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestDepartmentDao {
    @Autowired
    private DepartmentDao departmentDao;
    @Test
    public void testFindAllDepartment() throws IOException {
        List<Department> allDepartment = departmentDao.findAllDepartment();
        System.out.println(allDepartment);
    }
    @Test
    public void testAddDepartment(){
        boolean b = departmentDao.addDepartment("侯倩不", "侯倩不");
        System.out.println(b);
    }
    @Test
    public void testDelete(){
        departmentDao.deleteDepartment("后勤部4");
    }
    @Test
    public void testUpdate(){
        Department department = new Department();
        department.setdId(27);
        department.setDepartmentName("后勤891");
        department.setDepartmentDesc("后勤981");
        boolean b = departmentDao.updateDepartment(department);
        System.out.println(b);
    }
}
