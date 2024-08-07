package com.mzm.Fitpin.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Item {
    private int itemKey;
    private String itemName;
    private String itemType;
    private String itemBrand;
    private String itemStyle;
    private int itemCnt;
    private String itemContent;
    private int itemPrice;
    private Date itemDate;

    // Getters and Setters
    // ...
}