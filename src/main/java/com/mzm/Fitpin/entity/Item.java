package com.mzm.Fitpin.entity;

import lombok.Data;
import java.sql.Date;

@Data
public class Item {
    private Integer itemKey;
    private Integer itemNum;
    private String itemName;
    private String itemImg1;
    private String itemImg2;
    private String itemImg3;
    private String itemContent;
    private Integer itemPrice;
    private Integer itemSale;
    private Integer itemCnt;
    private Date itemDate;
}
