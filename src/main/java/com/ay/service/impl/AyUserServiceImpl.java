package com.ay.service.impl;

import com.ay.dao.AyUserDao;
import com.ay.model.AyUser;
import com.ay.service.AyUserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AyUserServiceImpl implements AyUserService {

    @Resource
    private AyUserDao ayUserDao;

    public List<AyUser> findAll() {
        return ayUserDao.findAll();
    }

    //
    public AyUser findById(String id) {
        return ayUserDao.findById(id);
    }

    //
//    public List<AyUser> findByName(String name) {
//        return ayUserDao.findByName(name);
//    }
//
//    public int countByName(String name) {
//        return ayUserDao.countByName(name);
//    }
//
    public int insert(AyUser ayUser) {
        return ayUserDao.insert(ayUser);
    }

    @Transactional
    public int update(AyUser ayUser) {
        int count = ayUserDao.update(ayUser);
        String s = null;
        s.split(",");
        return count;
    }
//
//    public int delete(int id) {
//        return ayUserDao.delete(id);
//    }
//
//    public int deleteByName(String name) {
//        return ayUserDao.deleteByName(name);
//    }
//
//    public List<AyUser> findByIds(List<Integer> ids) {
//        return ayUserDao.findByIds(ids);
//    }
//
//    public List<AyUser> findByNameAndPassword(String name, String password) {
//        return ayUserDao.findByNameAndPassword(name, password);
//    }

//    public List<AyUser> findByNameAndPassword(Map<String,String> map) {
//        return ayUserDao.findByNameAndPassword(map);
//    }
}
