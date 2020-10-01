package com.ay.model;

import java.io.Serializable;

/**
 * 描述：学生实体
 *
 * @author Ay
 * @create 2018/05/01
 **/
public class AyStudent implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
    //一个学生只能在一个学校
    private AySchool aySchool;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public AySchool getAySchool() {
        return aySchool;
    }

    public void setAySchool(AySchool aySchool) {
        this.aySchool = aySchool;
    }
}
