package com.qs.fruitshop.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Goods {
    private Integer id;
    @JsonProperty("goodsNo")
    private String goodsNo;
    @JsonProperty("goodsName")
    private String goodsName;
    private String supplier;
    private String des;
    @JsonProperty("goodsImg")
    private String goodsImg;
    private Double price;
    @JsonProperty("typeId")
    private Integer typeId;
    private String typeName;
    private Integer stock;
    private Integer sell;
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSell() {
        return sell;
    }

    public void setSell(Integer sell) {
        this.sell = sell;
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
        SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time2;
        try {
            time2 = sdf1.parse(updateTime);
            this.updateTime = time2;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Goods(Integer id, String goodsNo, String goodsName, String supplier, String des, String goodsImg, Double price, Integer typeId, String typeName, Integer stock, Integer sell, Date createTime, Date updateTime) {
        this.id = id;
        this.goodsNo = goodsNo;
        this.goodsName = goodsName;
        this.supplier = supplier;
        this.des = des;
        this.goodsImg = goodsImg;
        this.price = price;
        this.typeId = typeId;
        this.typeName = typeName;
        this.stock = stock;
        this.sell = sell;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Goods() {
    }
}
