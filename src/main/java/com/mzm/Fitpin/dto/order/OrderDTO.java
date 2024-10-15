package com.mzm.Fitpin.dto.order;

import lombok.Data;

@Data
public class OrderDTO {
    private int itemKey;
    private int userKey;
    private String userName;
    private String userAddr;
    private String userNumber;
    private String itemName;
    private String itemImg;
    private String itemSize;
    private int itemPrice;
    private int itemTotal;
    private int pitPrice;
    private int qty;
}
