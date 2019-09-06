package com.panda.controller;

import com.panda.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by Administrator on 2019/9/3.
 */
@Controller
public class HelloController {

//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "login";
//    }

    //这个方法目前是用来测试异常的
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user")String user){
        if (user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello world";
    }

//    @ResponseBody
//    @RequestMapping("/hello")
//    public String hello(){
//        return "hello world";
//    }

    //查出一些数据，在页面展示
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好！！</h1>");
        map.put("users", Arrays.asList("zhangsan","lis","wangwu"));
        return "success";
    }

}
