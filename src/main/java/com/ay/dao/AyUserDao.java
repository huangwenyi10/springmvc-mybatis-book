package com.ay.dao;

import com.ay.model.AyUser;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AyUserDao {

    List<AyUser> findAll();

    AyUser findById(String id);

    List<AyUser> findByName(String name);

    int countByName(String name);

    int insert(AyUser ayUser);

    int update(AyUser ayUser);

    int delete(int id);

    int deleteByName(String name);
}
