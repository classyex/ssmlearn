package com.github.classyex.web.controller;

import com.github.classyex.web.contrller.UserController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by yex on 16-11-12.
 */
public class UserControllerTest extends BaseControllerTest {
    
    @Autowired
    private UserController userController;

    @Test
    public void login() throws Exception {
        mockMvc.perform((post("/userAction/login").param("userName", "admin").param("password", "1"))).andExpect(status().isOk())
                .andDo(print());
    }
}
