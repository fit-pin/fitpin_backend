package com.mzm.Fitpin.dto.order;

import lombok.Data;

@Data
public class PaymentDTO {
    private int paymentId;
    private int orderKey;
    private String userEmail;
    private String userName;
    private String userAddr;
    private String userNumber;
    private int itemKey;
    private String optional;
    private String itemImg;
    private String itemSize;
    private int itemPrice;
    private int itemTotal;
    private int pitPrice;
    private int qty;
    private String paymentMethod;
    private int paymentAmount;

}