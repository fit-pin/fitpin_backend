package com.mzm.Fitpin.post;

import lombok.Data;

import java.sql.Date;

@Data
public class ItemPostRequest {

    private Integer itemKey;         // 제품 고유번호 (PK)
    private Integer itemNum;       // 제품 번호
    private String  itemName;      // 제품 이름
    private String itemImg1;   // 제품 이미지1
    private String itemImg2;   // 제품 이미지2
    private String itemImg3;   // 제품 이미지3
    private String itemContent;  // 제품 설명
    private Integer itemPrice;    // 제품 가격
    private Integer itemSale;    // 제품 판매가
    private Integer itemCnt;   // 제품 재고
    private Date itemDate;  // 제품 등록일

}
