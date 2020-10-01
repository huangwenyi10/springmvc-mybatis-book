package com.ay.service.impl;
import com.ay.dao.SysUserDao;
import com.ay.dto.SysUserDTO;
import com.ay.model.SysUser;
import com.ay.service.SysUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务实现类
 * Created by Ay on 2020/3/22.
 */
@Service
public class SysUserServiceImpl implements SysUserService{
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

    public boolean update(SysUserDTO user) {
        SysUser sysUser = convert(user);
        sysUserDao.update(sysUser);
        return true;
    }

    public SysUser findById(Integer id) {
        return sysUserDao.findById(id);
    }

    public SysUser convert(SysUserDTO user){
        SysUser sysUser = new SysUser();
        if(user.getId() != null){
            sysUser.setId(Integer.valueOf(user.getId()));
        }
        sysUser.setName(user.getName());
        sysUser.setNo(user.getNo());
        sysUser.setStatus(user.getStatus());
        if(user.getStatus().equals("在职")){
            sysUser.setStatus("1");
        }
        if(user.getStatus().equals("已离职")){
            sysUser.setStatus("2");
        }
        sysUser.setPosition(user.getPosition());
        sysUser.setReason(user.getReason());
        return sysUser;
    }

    public boolean updateStatus(SysUserDTO user) {
        sysUserDao.updateStatus(convert(user));
        return true;
    }
}
