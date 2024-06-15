package com.mzm.Fitpin.controller;

import com.mzm.Fitpin.dto.MemberDto;
import com.mzm.Fitpin.entity.Member;
import com.mzm.Fitpin.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<String> registerMember(@RequestBody MemberDto memberDto) {
        if (!memberDto.getUserPwd().equals(memberDto.getUserPwdConfirm())) {
            return ResponseEntity.badRequest().body("비밀번호가 일치하지 않습니다.");
        }

        Member member = new Member();
        member.setUserEmail(memberDto.getUserEmail());
        member.setUserPwd(memberDto.getUserPwd());
        member.setUserName(memberDto.getUserName());

        registerService.registerMember(member, memberDto.getUserPwdConfirm());
        return ResponseEntity.ok("이메일, 비밀번호, 이름 POST 요청 완료");
    }
}
