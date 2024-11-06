package com.mzm.Fitpin.dto.pit;

import lombok.Data;

@Data
public class PitItemCartDTO {
    private int itemKey;
    private int cartKey;
    private String itemType;
    private String itemSize;
    private Float itemHeight;
    private Float itemShoulder;
    private Float itemChest;
    private Float itemSleeve;
    private Float frontrise;
    private Float itemWaists;
    private Float itemThighs;
    private Float itemHemWidth;
    private Float itemhipWidth; // 엉덩이단면 추가

}