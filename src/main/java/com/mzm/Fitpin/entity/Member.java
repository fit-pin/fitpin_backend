package com.mzm.Fitpin.entity;

import lombok.Data;
//Member 테이블 엔티티 클래스입니다.

@Data
public class Member {
    private Integer userKey;
    private String userEmail;
    private String userPwd;
    private String userName;
    private String userNumber;
    private String userNickname;
    private String userAddr;
    private String userGender;
    private Integer userHeight;
    private Integer userWeight;
    private Integer userForm;
    private Integer userCash;
}
