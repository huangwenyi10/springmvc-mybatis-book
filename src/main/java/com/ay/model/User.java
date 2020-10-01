package com.ay.model;

import java.io.Serializable;

/**
 * 描述：用户表
 *
 * @author Ay
 * @date 2017/9/16.
 */
public class User implements Serializable {
    /**
     * 主键
     */
    private String id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 账户
     */
    private String account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}

