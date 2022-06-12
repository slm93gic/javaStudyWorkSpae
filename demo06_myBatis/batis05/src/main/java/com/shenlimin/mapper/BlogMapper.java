package com.shenlimin.mapper;

import com.shenlimin.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //有时候，我们不想用到所有的查询条件，只想选择其中的一个，查询条件有一个满足即可，使用 choose 标签可以解决此类问题，类似于 Java 的 switch 语句
    List<Blog> queryBlogChoose(Map map);

    //验证foreach
    List<Blog> queryBlogForeach(Map map);

    //新增一个博客
    int addBlog(Blog blog);

    //根据作者名字和博客名字来查询博客！如果作者名字为空，那么只根据博客名字查询，反之，则根据作者名来查询
    List<Blog> queryBlogIf(Map map);

    List<Blog> queryBlogIf1(Map map);

    //sql片段
    List<Blog> queryBlogIf2(Map map);

    int updateBlog(Map map);
}