package com.mzm.Fitpin.entity;

import lombok.Data;

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
    private Integer userFit;  //Todo: 관련ㅌ코드수정해야함!!!!!!!!! 완
    private Integer userCash;
}
