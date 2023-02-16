package com.qs.fruitshop.pojo;

import java.util.Date;

public class Address {
    private int id;
    private String name;
    private String phone;
    private String address;
    private int uid;
    private Date creatTime;
    private Date updateTime;
    private int status;

    public Address() {
    }

    public Address(int id, String name, String phone, String address, int uid, Date creatTime, Date updateTime, int status) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.uid = uid;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", uid=" + uid +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }
}
