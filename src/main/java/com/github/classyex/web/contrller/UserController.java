package com.github.classyex.web.contrller;

import com.github.classyex.web.domain.User;
import com.github.classyex.web.service.UserService;
import com.github.classyex.web.util.GsonUtils;
import com.github.classyex.web.util.ResponseObj;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户登录处理
 * Created by yex on 16-10-10.
 */
@Controller
@RequestMapping("/userAction")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        Assert.notNull(userService, "userService must not null");
        this.userService = userService;
    }

    /**
     * 为什么返回值是一个ModelAndView，ModelAndView代表一个web页面<br/>
     * setViewName是设置一个jsp页面的名称
     * @param req   http请求
     * @param user  发起请求后，spring接收到请求，然后封装的bean数据
     * @return  返回一个web页面
     * @throws Exception 登录报错
     */
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ModelAndView reg(HttpServletRequest req, User user) throws Exception {
        ModelAndView mav = new ModelAndView();  //创建一个jsp页面对象
        mav.setViewName("home");    //设置JSP文件名
        if (null == user) {
            mav.addObject("message", "用户信息不能为空！");  //加入提示信息，在jsp中我们直接使用${对象名称}就能获取对应的内容
            return mav; //返回页面
        }
        if (StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())) {
            mav.addObject("message", "用户名或密码不能为空！");
            return mav;
        }
        if (null != userService.findUser(user)) {
            mav.addObject("message", "用户已经存在！");
            return mav;
        }
        try {
            userService.add(user);
        } catch (Exception e) {
            e.printStackTrace();
            mav.addObject("message", "错误：用户其他信息错误");
            return mav;
        }
        mav.addObject("code", 110);
        mav.addObject("message", "恭喜。注册成功");
        req.getSession().setAttribute("user", user);
        return mav;
    }

    /**
     * 登录接口
     * @param user 用户的登录信息
     * @return 登录的结果
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8"})
    @ResponseBody
    public ModelAndView login(User user) {
        ModelAndView mav = new ModelAndView("home");
        String result;
        ResponseObj<User> responseObj;
        if (null == user) {
            responseObj = new ResponseObj<User>();
            responseObj.setCode(ResponseObj.EMPTY);
            responseObj.setMsg("登录信息不能为空");
            result = GsonUtils.gson.toJson(responseObj);    //转换的json数据
            mav.addObject("result", result);
            return mav; //返回页面
        }
        if (StringUtils.isEmpty(user.getId()) || StringUtils.isEmpty(user.getPassword())) {
            responseObj = new ResponseObj<User>();
            responseObj.setCode(ResponseObj.FAILED);
            responseObj.setMsg("用户名或密码不能为空");
            Gson gson = GsonUtils.gson;
            result = GsonUtils.gson.toJson(responseObj);
            mav.addObject("result", result);
            return mav;
        }
        //查找用户
        User user1 = userService.findUser(user);
        if (null == user1) {
            responseObj = new ResponseObj<User>();
            responseObj.setCode(ResponseObj.EMPTY);
            responseObj.setMsg("未找到该用户");
            result = GsonUtils.gson.toJson(responseObj);
        } else {
            if (user.getPassword().equals(user1.getPassword())) {
                responseObj = new ResponseObj<User>();
                responseObj.setCode(ResponseObj.OK);
                responseObj.setMsg(ResponseObj.OK_STR);
                result = GsonUtils.gson.toJson(responseObj);
            } else {
                responseObj = new ResponseObj<User>();
                responseObj.setCode(ResponseObj.FAILED);
                responseObj.setMsg("用户密码错误");
                result = GsonUtils.gson.toJson(responseObj);
            }
        }
        mav.addObject("result", result);
        return mav;
    }

}
