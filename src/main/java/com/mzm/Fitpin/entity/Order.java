package com.mzm.Fitpin.entity;

import lombok.Data;

@Data
public class Order {
    private Integer itemKey;
    private String userName;
    private String userAddr;
    private String userNumber;
    private String itemName;
    private String itemImg1;
    private Integer itemSize;
    private Integer itemPrice;
    private Integer itemBuycnt;
    private Integer itemTotal;
    private Integer pitPrice;
}
