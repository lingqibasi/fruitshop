package com.qs.fruitshop.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private Integer id;
    private String orderSn;
    private Double totalPrice;
    private Integer uid;
    private Integer addressId;
    private Integer state;

    private Address address; // 收货人地址对象
    private List<OrderDetail> ordersDetail;
//    @JsonFormat(pattern = "yyyy-MM-dd ", timezone = "GMT+8")
    private Date createTime;
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;

    private List<OrderDetail> goodsInfo;

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

}
