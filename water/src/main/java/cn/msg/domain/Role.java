package cn.msg.domain;

import java.io.Serializable;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/23 22:54
 */
public class Role implements Serializable {
    private Integer rId;
    private String roleName;
    private String roleDesc;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
