package com.qs.fruitshop.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class User {

    private int id;
    private String username;
    private String password;
    private String name;
    private String role;
    private int sex;
    private int age;
//    @JsonFormat(pattern = "yyyy-MM-dd ", timezone = "UTC")
    private Date createTime;
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT%2B")
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time1;
        try {
            time1 = sdf1.parse(createTime);
            this.createTime = time1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time2;
        try {
            time2 = sdf.parse(updateTime);
            this.updateTime = time2;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public User() {
    }

    public User(int id, String username, String password, String name, String role, int sex, int age, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
        this.sex = sex;
        this.age = age;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", creatTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
