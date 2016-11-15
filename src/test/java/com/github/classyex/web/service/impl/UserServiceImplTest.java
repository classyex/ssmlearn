package com.github.classyex.web.service.impl;

import com.github.classyex.web.dao.BaseTest;
import com.github.classyex.web.domain.User;
import com.github.classyex.web.exception.*;
import com.github.classyex.web.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户service测试类
 * Created by yex on 16-10-10.
 */
public class UserServiceImplTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void add() throws Exception {
        User user = new User();
        try {
            userService.add(user);
        } catch (UserCanNotBeNullException e) {
            //用户不能为空异常抛出
            e.printStackTrace();
        } catch (UserNameCanNotBeNullException e) {
            //用户名不能为空
            e.printStackTrace();
        } catch (UserPwdCanNotBeNullException e) {
            //用户密码不能为空
            e.printStackTrace();
        } catch (UserAireadyExistException e) {
            //用户存在抛出
            e.printStackTrace();
        } catch (OtherThingsException e) {
            //其他综合异常或是不能处理的异常
            e.printStackTrace();
        }
    }

}