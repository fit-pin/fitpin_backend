package com.mzm.Fitpin.service;

import com.mzm.Fitpin.entity.Member;
import com.mzm.Fitpin.exception.CustomException;
import com.mzm.Fitpin.mapper.RegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private RegisterMapper registerMapper;

    public void registerMember(Member member, String userPwdConfirm) {
        // 예외 처리를 하지 않고 그대로 비즈니스 로직 수행
        registerMapper.insertMember(member);
    }

    public void deleteMember(String userEmail) {
        // 회원탈퇴 로직
        registerMapper.deleteMember(userEmail);
    }
}

