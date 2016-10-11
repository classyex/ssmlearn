package com.github.classyex.web.dao;

import com.github.classyex.web.domain.User;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * 用户操作接口
 * Created by yex on 16-10-10.
 */
@Repository
public interface UserDao extends Dao<User> {

    int add(User user);

    int del(User user);

    int update(User user);

    User findOneById(Serializable Id);

    List<User> findAll();

}
