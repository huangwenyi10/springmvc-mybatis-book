package com.ay.dao;

import com.ay.model.AyUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AyUserDao {

    List<AyUser> listAllUser();
}
