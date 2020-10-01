package com.ay.test;

import com.ay.dao.MoodDao;
import com.ay.dao.UserDao;
import com.ay.model.Mood;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：用户DAO测试类
 *
 * @author Ay
 * @create 2018/05/04
 **/
public class MoodDaoTest extends BaseJunit4Test {

    @Resource
    private MoodDao moodDao;

    @Test
    public void testFindAll() {
        List<Mood> moodList = moodDao.findAll();
        System.out.println(moodList.size());
    }
}
