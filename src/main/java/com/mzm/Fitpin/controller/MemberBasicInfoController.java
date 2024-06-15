package com.mzm.Fitpin.controller;

import com.mzm.Fitpin.dto.MemberBasicInfoRequest;
import com.mzm.Fitpin.service.MemberBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//유저 email을 키값으로 받아서 성별, 키 , 몸무게를 POST하는 API입니다
@RestController
@RequestMapping("/api/members")

public class MemberBasicInfoController {

    @Autowired
    private MemberBasicInfoService memberBasicInfoService;

    @PostMapping("/basicInfo/{userEmail}")
    public ResponseEntity<String> updateBasicInfo(@PathVariable String userEmail, @RequestBody MemberBasicInfoRequest memberBasicInfoRequest) {
        memberBasicInfoService.updateBasicInfo(userEmail, memberBasicInfoRequest);
        return ResponseEntity.ok("기본 정보 업데이트 완료: 성별, 키, 몸무게");
    }
}

