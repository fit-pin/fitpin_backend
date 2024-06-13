package com.mzm.Fitpin.controller;

import com.mzm.Fitpin.entity.Member;
import com.mzm.Fitpin.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private LoginMapper loginMapper;
    //로그인 확인용 엔드포인트입니다.
    @GetMapping("/home")
    public String home() {
        // 현재 로그인된 사용자 아이디 가져오기
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userId = principal.getUsername();

        // 데이터베이스에서 사용자 정보 조회
        Member member = loginMapper.findByUserId(userId);

        // 닉네임 반환
        return member.getUserNickname()+ "님, 반갑습니다.";
    }
}
