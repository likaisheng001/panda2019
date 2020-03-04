package com.panda.b2019.b11springmvc.domain;/**
 * Created by My on 2020-03-04.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 09:53:51 2020-03-04
 * @Modified By:
 */
public class Person {
    private Long id;
    private String name;
    public Person(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
