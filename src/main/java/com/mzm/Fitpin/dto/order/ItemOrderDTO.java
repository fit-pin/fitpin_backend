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
    private PitItemOrderDTO pitItemOrder; // 수선 정보
}
