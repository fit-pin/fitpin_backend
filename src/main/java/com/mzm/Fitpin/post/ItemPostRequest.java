package com.mzm.Fitpin.post;

import lombok.Data;

import java.sql.Date;

@Data
public class ItemPostRequest {
    private Integer itemKey;
    private Integer itemNum;
    private String itemName;
    private String itemType;
    private String itemBrand;
    private String itemImg1;
    private String itemImg2;
    private String itemImg3;
    private Integer itemCnt;
    private Integer itemSize;
    private String itemContent;
    private Integer itemPrice;
    private Date itemDate;
}
