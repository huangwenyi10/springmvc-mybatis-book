package com.ay.service;

import com.ay.model.AyUserAddress;

/**
 * 描述：地址服务接口
 *
 * @author Ay
 * @create 2018/05/01
 **/
public interface AyUserAddressService {

    AyUserAddress findById(Integer id);
}
