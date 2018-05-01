package com.ay.model;

import java.io.Serializable;

/**
 * 描述：角色实体
 *
 * @author Ay
 * @create 2018/05/01
 **/
public class AyUserRoleRel implements Serializable {

    private Integer id;

    private Integer userId;

    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
