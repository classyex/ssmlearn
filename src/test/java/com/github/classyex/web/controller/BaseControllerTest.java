package com.github.classyex.web.controller;

import com.github.classyex.web.dao.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by yex on 16-11-12.
 */
@WebAppConfiguration
public class BaseControllerTest extends BaseTest {

    protected MockHttpServletRequest request;
    protected MockHttpServletResponse response;

    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Before
    public void setUp(){
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
        mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void controller() throws Exception {

    }
}
