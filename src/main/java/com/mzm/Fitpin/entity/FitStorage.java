package com.mzm.Fitpin.entity;

import lombok.Data;

@Data
public class FitStorage {
    private String userEmail;
    private String fitStorageImg;  // 이미지 이름을 저장할 필드
    private String fitComment; //핏 코멘트(댓글) 필드
//추가
    private String itemType;
    private String itemBrand;
    private String itemSize;
    private String option;
}
