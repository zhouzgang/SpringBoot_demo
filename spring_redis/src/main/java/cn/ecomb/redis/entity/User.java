package cn.ecomb.redis.entity;

import java.io.Serializable;

/**
 * @author zhouzhigang
 * @date 2018/4/5.
 */
public class User implements Serializable{

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
