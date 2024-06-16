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
        if (!member.getUserPwd().equals(userPwdConfirm)) {
            throw new CustomException("비밀번호가 일치하지 않습니다.");
        }
        registerMapper.insertMember(member);
    }
}
