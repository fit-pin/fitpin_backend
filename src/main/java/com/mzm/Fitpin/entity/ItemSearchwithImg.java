package com.mzm.Fitpin.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class ItemSearchwithImg {
    private int itemKey;
    private String itemName;
    private String itemType;
    private String itemBrand;
    private String itemStyle;
    private int itemCnt;
    private String itemContent;
    private int itemPrice;
    private Date itemDate;

    private String itemImgName; // 추가 리턴
}
