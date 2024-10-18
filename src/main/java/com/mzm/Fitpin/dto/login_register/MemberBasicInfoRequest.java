package com.mzm.Fitpin.dto.login_register;

import lombok.Data;

import java.util.List;

@Data
public class MemberBasicInfoRequest {
    private String userGender;
    private Integer userHeight;
    private Integer userWeight;
    private String userFit; // userFit 필드 추가
    private List<UserPreferStyleDTO> style; // 선호 스타일 리스트 추가
}
