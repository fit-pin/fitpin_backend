package com.mzm.Fitpin.dto;

import lombok.Data;

@Data
public class MemberDto {
    private String userId;
    private String userPwd;
    private String userName;
    private String userNumber;
    private String userNickname;
    private String userAddr;
    private String userEmail;
    private String userGender;
    private Integer userHeight;
    private Integer userWeight;
    private Integer userForm;
    private Integer userCash;
}
