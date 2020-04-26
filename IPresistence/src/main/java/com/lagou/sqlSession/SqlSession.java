package com.lagou.sqlSession;

import java.sql.SQLException;
import java.util.List;

public interface SqlSession {

    //查询所有
    public <E> List<E> selectList(String statementid, Object... params) throws Exception;

    //根据条件查询单个
    public <T> T selectOne(String statementid, Object... params) throws Exception;


    //为Dao接口生成代理实现类
    public <T> T getMapper(Class<?> mapperClass);

    public void insert(String statementId, Object... params) throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException;

    public void delete(String statementId, Object... params) throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException;

    public void update(String statementId, Object... params) throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException;

}
