package com.panda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.Map;

/**
 * Created by Administrator on 2019/9/5.
 */
@Controller
public class LoginController {
    @PostMapping(value = "user/login")
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功,防止表单重复提交，可以重定向到主页
            return "redirect:/main.html";
        }else {
            //登录失败
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
