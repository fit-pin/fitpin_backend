package com.mzm.Fitpin.dto.mainpage;

import lombok.Data;

import java.util.List;

@Data
public class ItemWithImagesDTO {
    private int itemKey;
    private String itemName;
    private String itemBrand;
    private String itemStyle;
    private int itemPrice;
    private List<String> itemImgNames;
    private Double averageBmi; // 평균 BMI 지수 필드 추가

}

