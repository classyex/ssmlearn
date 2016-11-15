package com.github.classyex.web.contrller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 跳转到登录页面
 * Created by yex on 16-10-10.
 */
@Controller
@RequestMapping("/mvc")
public class MainController {

    /**
     * 登陆页面
     *
     * @return go to login page
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

}
