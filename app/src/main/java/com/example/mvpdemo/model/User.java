package com.example.mvpdemo.model;

/**
 * @author SpreadWater
 * @Date 2021-03-22
 * @Time 11:24
 * @description TODO(封装用户信息)
 */

public class User {

    private String userId;
    private String userName;
    private String password;
    private String age;
    private String sex;
    private String job;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
