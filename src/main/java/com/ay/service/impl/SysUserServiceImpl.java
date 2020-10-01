package com.ay.service.impl;

import com.ay.dao.SysUserDao;
import com.ay.dto.SysUserDTO;
import com.ay.model.SysUser;
import com.ay.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务实现类
 * Created by Ay on 2020/3/22.
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    public List<SysUser> findAll() {
        return sysUserDao.findAll();
    }

    public boolean save(SysUserDTO user) {
        user.setStatus("1");
        sysUserDao.save(convert(user));
        return true;
    }

    public SysUser convert(SysUserDTO user) {
        SysUser sysUser = new SysUser();
        sysUser.setName(user.getName());
        sysUser.setNo(user.getNo());
        sysUser.setStatus(user.getStatus());
        sysUser.setPosition(user.getPosition());
        return sysUser;
    }
}
