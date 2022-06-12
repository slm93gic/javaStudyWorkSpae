package com.shenlimin.rpc01;

import com.shenlimin.common.IUserService;
import com.shenlimin.common.User;

public class UserServiceImpl implements IUserService {

    @Override
    public User findUserById(Integer id) {
        return new User(id, "张三");
    }
}
