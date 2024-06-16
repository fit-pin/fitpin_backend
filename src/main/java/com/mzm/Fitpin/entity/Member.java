package com.mzm.Fitpin.entity;

import lombok.Data;
//member 테이블 엔티티 클래스!
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
    private String userFit;
    private Integer userCash;
}
