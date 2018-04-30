package com.ay.service;

import com.ay.model.AyUser;

import java.util.List;

public interface AyUserService {

    List<AyUser> findAll();

    AyUser findById(String id);

    List<AyUser> findByName(String name);

    int countByName(String name);

    int insert(AyUser ayUser);

    int update(AyUser ayUser);

    int delete(int id);

    int deleteByName(String name);
}
