import com.shenlimin.mapper.UserMapper;
import com.shenlimin.pojo.User;
import com.shenlimin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class MybatisTest {


    //二级缓存
    @Test
    public void testQueryUserById$Cache() {
        SqlSession session = MybatisUtils.getSqlSession();
        SqlSession session2 = MybatisUtils.getSqlSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        session.close();

        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println(user == user2);

        session2.close();
    }

    @Test
    public void testQueryUserById() {
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        System.out.println("===========================");
        User user = mapper.queryUserById(1);
        System.out.println(user);
        System.out.println("===========================");
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);
        System.out.println("===========================");
        System.out.println(user == user2);
        session.close();
    }

}
