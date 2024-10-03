package com.mzm.Fitpin.entity;

import lombok.Data;

@Data
public class FitStorage {
    private String userEmail;
    private String fitStorageImg;  // 이미지 이름을 저장할 필드
    private String fitComment; //핏 코멘트(댓글) 필드
}
