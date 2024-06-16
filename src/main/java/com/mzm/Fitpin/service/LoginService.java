package com.mzm.Fitpin.service;

import com.mzm.Fitpin.entity.Member;
import com.mzm.Fitpin.exception.CustomException;
import com.mzm.Fitpin.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public Member login(String userEmail, String password) {
        Member member = loginMapper.findByUserEmail(userEmail);
        if (member == null) {
            throw new CustomException("이메일을 찾을 수 없습니다.");
        }
        if (!member.getUserPwd().equals(password)) {
            throw new CustomException("비밀번호가 틀립니다.");
        }
        return member;
    }
}
