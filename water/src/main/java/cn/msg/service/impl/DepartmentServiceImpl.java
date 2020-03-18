package cn.msg.service.impl;

import cn.msg.dao.DepartmentDao;
import cn.msg.domain.Department;
import cn.msg.domain.PageBean;
import cn.msg.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/27 21:30
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public List<Department> findAllDepartment() {
        return departmentDao.findAllDepartment();
    }

    @Override
    public boolean addDepartment(String departmentName, String departmentDesc) {
        return departmentDao.addDepartment(departmentName,departmentDesc);
    }

    @Override
    public void deleteDepartment(String departmentName) {
        departmentDao.deleteDepartment(departmentName);
    }

    @Override
    public boolean updateDepartment(Department department) {
//        Department oldDepartment = departmentDao.findOneDepartment(department.getdId());
        return departmentDao.updateDepartment(department);
    }
}
