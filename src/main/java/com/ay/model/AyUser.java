package com.ay.model;
import java.io.Serializable;

/**
 * 用户实体
 * @author Ay
 * @date  2018/04/02
 */
public class AyUser implements Serializable{

    private Integer id;
    private String name;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
