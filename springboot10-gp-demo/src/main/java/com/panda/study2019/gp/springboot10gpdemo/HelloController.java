package com.panda.study2019.gp.springboot10gpdemo;/**
 * Created by My on 2020-02-22.
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 12:41:59 2020-02-22
 * @Modified By:
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello,Mic";
    }
}
