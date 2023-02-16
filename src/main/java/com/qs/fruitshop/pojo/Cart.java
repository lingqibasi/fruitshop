package com.qs.fruitshop.pojo;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Cart {
    private Integer id;
    private Integer goodsId;
    private Integer userId;
    private Integer number;
    private Integer status;
    private Date createTime;
    private Goods goods;

    public Cart() {
    }

    public Cart(Integer id, Integer goodsId, Integer userId, Integer number, Integer status, Date createTime, Goods goods) {
        this.id = id;
        this.goodsId = goodsId;
        this.userId = userId;
        this.number = number;
        this.status = status;
        this.createTime = createTime;
        this.goods = goods;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", userId=" + userId +
                ", number=" + number +
                ", status=" + status +
                ", createTime=" + createTime +
                ", goods=" + goods +
                '}';
    }
}
