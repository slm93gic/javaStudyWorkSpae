import com.shenlimin.mapper.BlogMapper;
import com.shenlimin.pojo.Blog;
import com.shenlimin.utils.IDUtil;
import com.shenlimin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MybatisTest {

    SqlSession session = MybatisUtils.getSqlSession();


    /**
     * 测试foreach
     */
    @Test
    public void testQueryBlogForeach() {
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids", ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        System.out.println(blogs);
        session.close();
    }


    @Test
    public void testUpdateBlog() {
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title", "动态SQL");
        map.put("author", "秦疆");
        map.put("id", "f8b3a22d57094d73bf9b0757a0f57de8");

        mapper.updateBlog(map);
        session.commit();
        session.close();
    }

    @Test
    public void testQueryBlogIf() {
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title", "");
        map.put("author", "狂神说");
        List<Blog> blogs = mapper.queryBlogIf1(map);
        System.out.println(blogs);
        session.close();
    }

    @Test
    public void addInitBlog() {
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtil.genId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.commit();
        session.close();
    }

}
