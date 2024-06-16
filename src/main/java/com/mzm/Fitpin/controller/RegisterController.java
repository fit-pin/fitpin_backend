package com.mzm.Fitpin.controller;

import com.mzm.Fitpin.dto.MemberDto;
import com.mzm.Fitpin.entity.Member;
import com.mzm.Fitpin.exception.CustomException;
import com.mzm.Fitpin.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/members")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<?> registerMember(@RequestBody MemberDto memberDto) {
        try {
            if (!memberDto.getUserPwd().equals(memberDto.getUserPwdConfirm())) {
                throw new CustomException("비밀번호가 일치하지 않습니다.");
            }

            Member member = new Member();
            member.setUserEmail(memberDto.getUserEmail());
            member.setUserPwd(memberDto.getUserPwd());
            member.setUserName(memberDto.getUserName());

            registerService.registerMember(member, memberDto.getUserPwdConfirm());
            return ResponseEntity.ok(Collections.singletonMap("message", "회원가입이 완료되었습니다."));
        } catch (CustomException e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "회원가입 중 오류가 발생했습니다."));
        }
    }
}
