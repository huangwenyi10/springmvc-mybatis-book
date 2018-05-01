package com.ay.model;

import java.io.Serializable;
import java.util.List;

/**
 * 描述：角色实体
 *
 * @author Ay
 * @create 2018/05/01
 **/
public class AyRole implements Serializable {

    private Integer id;

    private String name;

    private List<AyUser> ayUserList;

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

    public List<AyUser> getAyUserList() {
        return ayUserList;
    }

    public void setAyUserList(List<AyUser> ayUserList) {
        this.ayUserList = ayUserList;
    }
}
