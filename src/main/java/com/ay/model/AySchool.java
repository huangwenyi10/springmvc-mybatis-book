package com.ay.model;

import java.io.Serializable;
import java.util.List;

/**
 * 描述：学校实体
 *
 * @author Ay
 * @create 2018/05/01
 **/
public class AySchool implements Serializable {

    private Integer id;
    private String name;
    //一个学校有多个学生
    private List<AyStudent> students;

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

    public List<AyStudent> getStudents() {
        return students;
    }

    public void setStudents(List<AyStudent> students) {
        this.students = students;
    }
}
