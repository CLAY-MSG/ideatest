package cn.msg.service;

import cn.msg.domain.Department;
import cn.msg.domain.PageBean;
import cn.msg.domain.User;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/23 23:38
 */
public interface DepartmentService {
    /**
     * 查询所有部门信息
     * @return
     */
    public List<Department> findAllDepartment();

    /**
     * 添加部门
     * @param departmentName
     * @param departmentDesc
     * @return
     */
    boolean addDepartment(String departmentName, String departmentDesc);

    /**
     * 删除部门
     * @param departmentName
     */
    void deleteDepartment(String departmentName);

    /**
     * 修改部门
     * @param department
     * @return
     */
    boolean updateDepartment(Department department);
}
