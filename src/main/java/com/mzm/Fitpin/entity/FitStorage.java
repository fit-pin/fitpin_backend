package com.mzm.Fitpin.entity;

import lombok.Data;

@Data
public class FitStorage {
    private int fitStorageKey;
    private String userEmail;
    private String fitStorageImg;  // 이미지 이름을 저장할 필드
    private String fitComment; // 핏 코멘트(댓글) 필드
    private String itemName; // 추가된 필드
    private String itemType;
    private String itemBrand;
    private String itemSize;
    private String option;
    private boolean deleteStatus;
    private String commentDate;

    private String userName; // 유저 이름 필드 추가 원래
}
