package com.mzm.Fitpin.dto.login_register;

import lombok.Data;

@Data
public class MemberDto {
    private String userEmail;
    private String userPwd;
    private String userName;
    private String userPwdConfirm; // 비밀번호 확인 필드 추가

}
