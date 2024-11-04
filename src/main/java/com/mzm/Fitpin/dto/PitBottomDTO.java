package com.mzm.Fitpin.dto;

import lombok.Data;

@Data
public class PitBottomDTO {
    private int itemKey;
    private int cartKey;
    private String itemSize;
    private Float itemHeight;
    private Float itemWaists;
    private Float itemThighs;
    private Float frontrise;   // 기존 itemRise -> frontrise로 수정
    private Float itemHemWidth; // 기존 itemHem -> itemHemWidth로 수정
}
