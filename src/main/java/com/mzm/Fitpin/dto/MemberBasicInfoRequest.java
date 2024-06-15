package com.mzm.Fitpin.dto;

import lombok.Data;

@Data
public class MemberBasicInfoRequest {
    private String userGender;
    private Integer userHeight;
    private Integer userWeight;
}
