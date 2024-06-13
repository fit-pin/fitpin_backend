package com.mzm.Fitpin.service;

import com.mzm.Fitpin.entity.Member;
import com.mzm.Fitpin.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Member login(String userId, String password) {
        Member member = loginMapper.findByUserId(userId);
        if (member == null || !passwordEncoder.matches(password, member.getUserPwd())) {
            throw new RuntimeException("Invalid credentials");
        }
        return member;
    }
}
