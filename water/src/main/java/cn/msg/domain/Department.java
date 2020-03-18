package cn.msg.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/23 22:48
 */
public class Department implements Serializable {
    /**
     * 部门id
     */
    private Integer dId;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 部门职能
     */
    private String departmentDesc;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDesc() {
        return departmentDesc;
    }

    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dId=" + dId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentDesc='" + departmentDesc + '\'' +
                '}';
    }

}
