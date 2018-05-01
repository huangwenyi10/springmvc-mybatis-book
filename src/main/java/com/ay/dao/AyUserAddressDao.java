package com.ay.dao;

import com.ay.model.AyUser;
import com.ay.model.AyUserAddress;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AyUserAddressDao {

    AyUserAddress findById(Integer id);
}
