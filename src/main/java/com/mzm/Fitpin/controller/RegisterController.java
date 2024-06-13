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


    //회원가입을 위한 api입니다.
    @RestController
    @RequestMapping("/api/members")
    public class RegisterController {

        @Autowired
        private RegisterService registerService;

        @PostMapping("/register")
        public ResponseEntity<String> registerMember(@RequestBody MemberDto memberDto) {
            Member member = new Member();
            member.setUserId(memberDto.getUserId());
            member.setUserPwd(memberDto.getUserPwd());
            member.setUserName(memberDto.getUserName());
            member.setUserNumber(memberDto.getUserNumber());
            member.setUserNickname(memberDto.getUserNickname());
            member.setUserAddr(memberDto.getUserAddr());
            member.setUserEmail(memberDto.getUserEmail());
            member.setUserGender(memberDto.getUserGender());
            member.setUserHeight(memberDto.getUserHeight());
            member.setUserWeight(memberDto.getUserWeight());
            member.setUserForm(memberDto.getUserForm());
            member.setUserCash(memberDto.getUserCash());

            registerService.registerMember(member);
            return ResponseEntity.ok("User registered successfully");
        }
    }
