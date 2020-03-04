package com.panda.b2019.b11springmvc.controller;

import com.panda.b2019.b11springmvc.domain.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * {@link} {@link RestController}
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:46:59 2020-03-03
 * @Modified By:
 */
@RestController
public class PersonRestController {

    //http://localhost:8080/person/1?name=vulan
    @GetMapping("/person/{id}")
    public Person person(@PathVariable Long id,
                         @RequestParam(required = false) String name){
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        return person;
    }

    @PostMapping(value = "/person/json/to/properties",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, //请求类型
            produces = "application/properties+person")      //响应类型
    public Person personJsonToProperties(@RequestBody Person person){
//        @RequestBody的内容是JSON,
//        响应的内容是Properties
        return person;
    }

    @PostMapping(value = "/person/properties/to/json",
            consumes = "application/properties+person", //请求类型
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)      //响应类型
    public Person personPropertiesToJson(@RequestBody Person person){
//        @RequestBody的内容是Properties,
//        响应的内容是JSON
        return person;
    }
}
