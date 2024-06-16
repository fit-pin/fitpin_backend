package com.mzm.Fitpin.controller;

import com.mzm.Fitpin.dto.MemberBasicInfoRequest;
import com.mzm.Fitpin.service.MemberBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberBasicInfoController {

    @Autowired
    private MemberBasicInfoService memberBasicInfoService;

    @PostMapping("/basicInfo/{userEmail}")
    public ResponseEntity<String> updateBasicInfo(@PathVariable String userEmail, @RequestBody MemberBasicInfoRequest memberBasicInfoRequest) {
        memberBasicInfoService.updateBasicInfoWithStyles(userEmail, memberBasicInfoRequest);
        return ResponseEntity.ok("기본 정보 및 선호 스타일 업데이트 완료");
    }
}
