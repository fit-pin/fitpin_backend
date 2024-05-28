package com.mzm.Fitpin.post;

import lombok.Data;
import java.sql.Date;

@Data
public class OrderPostRequest {
    private Integer itemKey;         // 상품 고유번호 (PK)
    private String userName;         // 회원 이름
    private String userAddr;         // 회원 주소
    private String userNumber;       // 회원 전화번호
    private String itemName;         // 상품 이름
    private String itemImg1;         // 상품 이미지1
    private Integer itemSize;        // 상품 크기
    private Integer itemPrice;       // 상품 가격
    private Integer itemBuycnt;      // 상품 구매수량
    private Integer itemTotal;       // 상품 총가격
    private Integer pitPrice;        // 수선 가격 (nullable)
}
