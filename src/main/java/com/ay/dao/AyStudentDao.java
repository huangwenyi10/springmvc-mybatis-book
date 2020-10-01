package com.ay.dao;


import com.ay.model.AyStudent;

import java.util.List;

/**
 * 描述：学生DAO接口
 *
 * @author Ay
 * @create 2018/05/01
 **/
public interface AyStudentDao {

    AyStudent findById(Integer id);

    List<AyStudent> findBySchoolId(Integer id);
}
