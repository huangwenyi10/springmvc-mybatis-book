package com.ay.service.impl;

import com.ay.dao.AySchoolDao;
import com.ay.dao.AyUserAddressDao;
import com.ay.model.AySchool;
import com.ay.model.AyUserAddress;
import com.ay.service.AySchoolService;
import com.ay.service.AyUserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Ay
 * @create 2018/05/01
 **/
@Service
public class AySchoolServiceImpl implements AySchoolService {

    @Resource
    private AySchoolDao aySchoolDao;

    public AySchool findById(Integer id) {
        return aySchoolDao.findById(id);
    }
}
