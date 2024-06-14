package com.mzm.Fitpin.dto;

import lombok.Data;

//로그인 시 클라이언트에게 Email에 맞는 member 테이블을 반환하기 위한 dto입니다(고유키 번호 제외)
@Data
public class LoginResponseDto {
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
