package com.mzm.Fitpin.controller.app;

import com.mzm.Fitpin.dto.MemberDto;
import com.mzm.Fitpin.entity.Member;
import com.mzm.Fitpin.exception.CustomException;
import com.mzm.Fitpin.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
//살리기
@RestController
@RequestMapping("/api/members")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<?> registerMember(@RequestBody MemberDto memberDto) {
        try {
            if (!memberDto.getUserPwd().equals(memberDto.getUserPwdConfirm())) {
                return ResponseEntity.badRequest().body(Collections.singletonMap("message", "비밀번호가 일치하지 않습니다."));
            }

            Member member = new Member();
            member.setUserEmail(memberDto.getUserEmail());
            member.setUserPwd(memberDto.getUserPwd());
            member.setUserName(memberDto.getUserName());

            // 서비스 호출
            registerService.registerMember(member, memberDto.getUserPwdConfirm());
            return ResponseEntity.ok(Collections.singletonMap("message", "회원가입이 완료되었습니다."));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "회원가입 중 오류가 발생했습니다."));
        }
    }

    @PostMapping("/delete_id")
    public ResponseEntity<?> deleteMember(@RequestBody MemberDto memberDto) {
        try {
            // 서비스 호출
            registerService.deleteMember(memberDto.getUserEmail());
            return ResponseEntity.ok(Collections.singletonMap("message", "회원탈퇴가 완료되었습니다."));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "회원탈퇴 중 오류가 발생했습니다."));
        }
    }
}

