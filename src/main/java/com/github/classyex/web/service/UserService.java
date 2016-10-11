package com.github.classyex.web.service;

import com.github.classyex.web.domain.User;

/**
 * 用户service
 * Created by yex on 16-10-10.
 */
public interface UserService extends BaseService<User> {

    //添加用户的实例
    void add(User user) throws Exception;

    User findUser(User user);
}
