package com.mzm.Fitpin.entity;

import lombok.Data;

@Data
public class PitTop {
    private Integer userKey;
    private Integer itemKey;
    private String itemSize;
    private Float itemHeight;
    private Float itemShoulder;
    private Float itemChest;
    private Float itemSleeve;
}
