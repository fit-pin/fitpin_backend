    package com.mzm.Fitpin.dto;

    import lombok.Data;

    @Data
    public class FitStorageDTO {
        private int fitStorageKey;
        private String userEmail;
        private String fitStorageImg;
        private String fitComment;
        private String itemName;
        private String itemType;
        private String itemBrand;
        private String itemSize;
        private String option;

        private String userName; // 유저 이름 필드 추가 (조인용)

    }
