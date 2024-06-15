package com.mzm.Fitpin.dto;

import lombok.Data;
import java.util.Date;

@Data
public class ItemDetailsResponse {
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
