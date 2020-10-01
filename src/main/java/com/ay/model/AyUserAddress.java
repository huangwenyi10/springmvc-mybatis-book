package com.ay.model;

import java.io.Serializable;

/**
 * 描述：用户地址实体
 *
 * @author Ay
 * @create 2018/05/01
 **/
public class AyUserAddress implements Serializable {

    private Integer id;
    private String name;

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
}
