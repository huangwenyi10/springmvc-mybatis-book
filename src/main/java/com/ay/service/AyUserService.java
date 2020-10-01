package com.ay.service;

import com.ay.model.AyUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface AyUserService {

    List<AyUser> findAll();

    //      List<AyUser> findAll(RowBounds rowBounds);
//
    AyUser findById(String id);

    //
//    List<AyUser> findByName(String name);
//
//    int countByName(String name);
//
    int insert(AyUser ayUser);

    //
    int update(AyUser ayUser);
//
//    int delete(int id);
//
//    int deleteByName(String name);

//    List<AyUser> findByNameAndPassword(Map<String, String> map);

//    List<AyUser> findByNameAndPassword(String name, String password);
//
//    List<AyUser> findByIds(List<Integer> ids);
}
