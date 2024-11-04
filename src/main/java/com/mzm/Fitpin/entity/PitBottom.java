package com.mzm.Fitpin.entity;

import lombok.Data;

@Data
public class PitBottom {
    private Integer userKey;
    private Integer itemKey;
    private String itemSize;
    private Float itemHeight;
    private Float itemWaists;
    private Float itemThighs;
    private Float frontrise;   // 기존 itemRise -> frontrise로 수정
    private Float itemHemWidth; // 기존 itemHem -> itemHemWidth로 수정
}
