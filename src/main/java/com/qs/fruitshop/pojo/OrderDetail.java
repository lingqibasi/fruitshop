package com.qs.fruitshop.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class OrderDetail {
    private int id;
    private int goodsId;//商品id
    private Integer ordersId;
    private String name;//商品名
    private String coverImage;//图片
    private int num;
    private double price;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;


}
