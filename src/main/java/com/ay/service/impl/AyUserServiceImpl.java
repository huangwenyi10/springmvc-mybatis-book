package com.ay.service.impl;

import com.ay.dao.AyUserDao;
import com.ay.model.AyUser;
import com.ay.service.AyUserService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AyUserServiceImpl implements AyUserService{

    @Resource
    private AyUserDao ayUserDao;

    public List<AyUser> findAll() {
        return ayUserDao.findAll();
    }

    public AyUser findById(String id) {
        return ayUserDao.findById(id);
    }

    public List<AyUser> findByName(String name) {
        return ayUserDao.findByName(name);
    }

    public int countByName(String name) {
        return ayUserDao.countByName(name);
    }

    public int insert(AyUser ayUser) {
        return ayUserDao.insert(ayUser);
    }

    public int update(AyUser ayUser) {
        return ayUserDao.update(ayUser);
    }

    public int delete(int id) {
        return ayUserDao.delete(id);
    }

    public int deleteByName(String name) {
        return ayUserDao.deleteByName(name);
    }
}