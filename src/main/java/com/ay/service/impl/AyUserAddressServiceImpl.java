package com.ay.service.impl;

import com.ay.dao.AyUserAddressDao;
import com.ay.model.AyUserAddress;
import com.ay.service.AyUserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Ay
 * @create 2018/05/01
 **/
@Service
public class AyUserAddressServiceImpl implements AyUserAddressService {

    @Resource
    private AyUserAddressDao ayUserAddressDao;

    public AyUserAddress findById(Integer id) {
        return ayUserAddressDao.findById(id);
    }
}
