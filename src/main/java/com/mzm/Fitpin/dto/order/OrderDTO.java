package com.mzm.Fitpin.dto.order;

import lombok.Data;

@Data
public class OrderDTO {
    private int itemKey;
    private String userEmail;
    private String userName;
    private String userAddr;
    private String userNumber;
    private String optional;
    private String itemImg;
    private String itemSize;
    private int itemPrice;
    private int itemTotal;
    private Integer  pitPrice; // 수선 비용, null일 수 있음
    private int qty;
    private int orderStatus; // 주문 상태 값 (0, 1, 2)
    private int pit; // 수선 여부 (0: 없음, 1: 있음)
    private String purchaseDate; // 구매 날짜

    // 조건문용 필드
    private String pitStatus; // "수선 있음" 또는 "수선 없음"
    private String displayPitPrice; // "경매중" 또는 수선 비용
    private String displayOrderStatus; // 주문 상태 문자열
}
