package com.ay.test;
import com.ay.dao.AyUserDao;
import com.ay.model.AyUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：用户DAO测试类
 * @author Ay
 * @create 2018/05/04
 **/
public class AyUserDaoTest extends BaseJunit4Test{

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
    public void testPageHelper(){
        //startPage(第几页, 多少条数据)
        PageHelper.startPage(0, 1);
        //查询所有用户
        List<AyUser> userList = ayUserDao.findAll();
        //用PageInfo对结果进行包装
        PageInfo pageInfo = new PageInfo(userList);
    }
}
