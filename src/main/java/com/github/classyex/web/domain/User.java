package com.github.classyex.web.domain;

/**
 * 用户实体类
 * Created by yex on 16-10-10.
 */
public class User {

    private String id;
    private String name;
    private String password;
    private Integer sex;

    public User() {
    }

    public User(String id) {
        this.id = id;
    }

    public User(String id, String name, String password, Integer sex) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                '}';
    }
}
