import com.shenlimin.mapper.UserDao;
import com.shenlimin.pojo.User;
import com.shenlimin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestBatis {

    SqlSession sqlSession = MybatisUtils.getSqlSession();


    @Test
    public void test() {
        //方式一：getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();
        userList.forEach(user -> System.out.println(user));
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testSelectUserById() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.selectUserById(11);
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User(11, "slm", "123");
        int slm = userDao.addUser(user);
        sqlSession.commit(); //提交事务,重点!不写的话不会提交到数据库
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User(11, "slm", "123456");
        int i = userDao.updateUser(user);
        System.out.println(i);
        sqlSession.commit(); //提交事务,重点!不写的话不会提交到数据库
        sqlSession.close();
    }

    @Test
    public void testDeleteUser() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int i = userDao.deleteUser(11);
        System.out.println(i);
        sqlSession.commit(); //提交事务,重点!不写的话不会提交到数据库
        sqlSession.close();
    }

    @Test
    public void testSelectUserByName() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.selectUserByName("%张%");
        System.out.println(user);
    }

}
