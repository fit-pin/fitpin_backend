package com.mzm.Fitpin.dto.order;

import lombok.Data;

@Data
public class ItemOrderDTO {
    private int itemKey;
    private String itemName;
    private String itemSize;
    private int itemPrice;
    private int qty;
    private boolean pitStatus;
    private Integer pitPrice; // 수선 가격 (수선을 선택하지 않은 경우 null 가능)
    private PitItemOrderDTO pitItemOrder; // 수선 정보
}
