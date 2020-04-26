package com.lagou.test;

import com.lagou.dao.IUserDao;
import com.lagou.io.Resource;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;

public class IPersistenceTest {

    @Test
    public void test() throws Exception {

        InputStream resourceAsStream = Resource.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //
        User user = new User();
        user.setId(3);
        user.setUsername("zhangsan");

       IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user2 = userDao.findByCondition(user);
        System.out.println(user2);

        List<User> list = userDao.findAll();
        for(User user1 : list){
            System.out.println(user1);
        }


       // delete 测试
       // userDao.delete(user);

        //userDao.insert(user);

       // userDao.update(user);
    }
}
