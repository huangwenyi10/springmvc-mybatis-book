package com.ay.dao;

import com.ay.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Dao层
 * Created by Ay on 2020/3/22.
 */
@Repository
public interface SysUserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    List<SysUser> findAll();

    void save(SysUser user);

    SysUser findById(Integer id);

    void update(@Param("user") SysUser user);

    void updateStatus(@Param("user") SysUser user);
}
