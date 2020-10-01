package com.ay.test;

import com.ay.dao.AyUserDao;
import com.ay.model.AyUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;

import javax.annotation.Resource;
import java.sql.Connection;
import java.util.List;

/**
 * 描述：用户DAO测试类
 *
 * @author Ay
 * @create 2018/05/04
 **/
public class AyUserDaoTest extends BaseJunit4Test {

    @Resource
    private AyUserDao ayUserDao;

//    @Test
//    public void testFindAll(){
//        List<AyUser> userList = ayUserDao.findAll(new RowBounds(0, 5));
//        for(AyUser ayUser: userList){
//            System.out.println("name: " + ayUser.getName());
//        }
//    }

    @Test
    public void testPageHelper() {
        //startPage(第几页, 多少条数据)
        PageHelper.startPage(0, 1);
        //查询所有用户
        List<AyUser> userList = ayUserDao.findAll();
        //用PageInfo对结果进行包装
        PageInfo pageInfo = new PageInfo(userList);
    }

    @Resource
    private SqlSessionFactoryBean sqlSessionFactoryBean;

    @Test
    public void testSessionCache() throws Exception {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AyUserDao ayUserDao = sqlSession.getMapper(AyUserDao.class);
        //第一次查询
        AyUser ayUser = ayUserDao.findById("1");
        System.out.println("name: " + ayUser.getName()
                + "  password:" + ayUser.getPassword());

        //执行commit操作（如：更新、插入、删除等操作）
        AyUser user = new AyUser();
        user.setId(1);
        user.setName("al");
        ayUserDao.update(ayUser);

        //第二次查询
        AyUser ayUser2 = ayUserDao.findById("1");
        System.out.println("name: " + ayUser2.getName()
                + "  password:" + ayUser2.getPassword());
        sqlSession.close();
        ;
    }

}
