package com.qs.fruitshop.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Page {
    private Integer pageNum = 1;
    private Integer pageSize = 5;
}
