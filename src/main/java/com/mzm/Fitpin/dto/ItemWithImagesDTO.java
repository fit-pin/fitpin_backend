package com.mzm.Fitpin.dto;

import lombok.Data;

import java.util.List;

@Data
public class ItemWithImagesDTO {
    private int itemKey;
    private String itemName;
    private String itemBrand;
    private String itemStyle;
    private int itemPrice;
    private List<String> itemImgUrls;
}
