package com.mzm.Fitpin.dto;

import lombok.Data;

import java.util.List;

@Data
public class ItemInfoDTO {
    private int itemKey;
    private String itemName;
    private String itemBrand;
    private String itemType;
    private String itemStyle;
    private int itemPrice;
    private String itemContent; // 추가된 필드
    private int pitPrice;
    private List<String> itemImgName;
    private List<ItemTopInfoDTO> itemTopInfo;
    private List<ItemBottomInfoDTO> itemBottomInfo;
}
