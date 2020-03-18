package cn.msg.dao;

import cn.msg.domain.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/27 21:30
 */
@Repository
public interface DepartmentDao {

    /**
     * 查询所有部门
     * @return
     */
    @Select("select * from department")
    public List<Department> findAllDepartment();

    /**
     * 添加部门
     * @param departmentName
     * @param departmentDesc
     * @return
     */
    @Insert("insert into department(departmentName, departmentDesc) values (#{departmentName},#{departmentName})")
    boolean addDepartment(@Param("departmentName") String departmentName,@Param("departmentDesc") String departmentDesc);

    /**
     * 删除部门
     * @param departmentName
     */
    @Delete("delete from department where departmentName = #{departmentName}")
    void deleteDepartment(@Param("departmentName") String departmentName);

    /**
     * 修改部门
     * @param department
     * @return
     */
    @Update("UPDATE department SET departmentName = #{departmentName}, departmentDesc = #{departmentDesc}  WHERE dId = #{dId}")
    boolean updateDepartment(Department department);
}
