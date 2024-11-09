package com.mzm.Fitpin.dto.order;

import lombok.Data;

@Data
public class PitItemOrderDTO {
    private int itemKey;
    private int orderKey;
    private String itemType;
    private String itemSize;
    private String itemName; // 추가된 필드
    private Float itemHeight;
    private Float itemShoulder;
    private Float itemChest;
    private Float itemSleeve;
    private Float frontrise;
    private Float itemWaists;
    private Float itemThighs;
    private Float itemHemWidth;
    private Float itemhipWidth;
}
