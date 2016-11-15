package com.github.classyex.web.controller;

import com.github.classyex.web.contrller.MainController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by yex on 16-11-12.
 */
public class MainControllerTest extends BaseControllerTest {

    @Autowired
    private MainController mainController;

    @Test
    public void login() throws Exception {
        mockMvc.perform((get("/mvc/login").param("userName", "admin").param("password", "1"))).andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void loginMethod() throws Exception {
        mainController.login();
        assertThat("login", is(mainController.login()));
    }
}
