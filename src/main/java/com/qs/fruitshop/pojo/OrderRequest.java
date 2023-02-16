package com.qs.fruitshop.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class OrderRequest {
    private String orderSn;
    private String totalPrice;
    private List<OrderDetail> goodsInfo;
    private Integer addressId;
    private Integer uid;
}
