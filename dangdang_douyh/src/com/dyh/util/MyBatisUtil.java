package com.dyh.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    //定义静态线程
    private static ThreadLocal<SqlSession> tol = new ThreadLocal<>();
    //定义会话工厂
    private static SqlSessionFactory factory;
    static {
        //读取mybatis配置文件
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
            //创建会话工厂
            factory = new SqlSessionFactoryBuilder().build(in);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //打开会话
    public static SqlSession openSession(){
        //获取线程会话
        SqlSession sqlSession = tol.get();
        if (sqlSession==null){
            sqlSession = factory.openSession();
            //将会话存入线程
            tol.set(sqlSession);
        }
        System.out.println("openSession:"+sqlSession);
        return sqlSession;
    }
    //关闭会话
    public static void close(){
        // 创建sqlSession会话
        SqlSession sqlSession = openSession();
        System.out.println("close:"+sqlSession);
        sqlSession.close();
        //
        tol.remove();
    }
   //获取映射
    public static<T> T getMapper(Class<T> c){
        SqlSession sqlSession = openSession();
        T t = sqlSession.getMapper(c);
        return t;

    }
    //5 提交事务
    public static void commit(){
        openSession().commit();
    }
    //6 事务回滚
    public static void rollback(){
        openSession().rollback();
    }
}
