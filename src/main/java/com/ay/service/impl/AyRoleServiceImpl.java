package com.ay.service.impl;

import com.ay.dao.AyRoleDao;
import com.ay.dao.AyUserDao;
import com.ay.model.AyRole;
import com.ay.model.AyUser;
import com.ay.service.AyRoleService;
import com.ay.service.AyUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AyRoleServiceImpl implements AyRoleService {

    @Resource
    private AyRoleDao ayRoleDao;

    public AyRole findById(String id) {
        return ayRoleDao.findById(id);
    }
}
