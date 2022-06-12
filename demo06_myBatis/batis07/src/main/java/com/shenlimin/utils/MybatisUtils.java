package com.shenlimin.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

//sqlSessionFactory-->sqlSession
public class MybatisUtils {


    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //使用Mybatis第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 既然有了 SqlSessionFactory，顾名思义，我们就可以从中获得 SqlSession 的实例了。
     * SqlSession 完全包含了面向数据库执行 SQL 命令所需的所有方法。
     *
     * @return
     */
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    public static void close(SqlSession session) {
        try {
            if (null != session) {
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
