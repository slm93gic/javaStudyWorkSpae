package com.shenlimin.mapper;

import com.shenlimin.pojo.User;

import java.util.List;

public interface UserDao {

    List<User> getUserList();

    //根据id查询用户
    User selectUserById(int id);

    //添加一个用户
    int addUser(User user);

    //修改一个用户
    int updateUser(User user);

    //根据id删除用户
    int deleteUser(int id);

    //根据用户名模式查询用户
    User selectUserByName(String name);
}
