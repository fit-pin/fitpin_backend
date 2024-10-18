package com.mzm.Fitpin.controller.app.login_register;

import com.mzm.Fitpin.dto.login_register.MemberBasicInfoRequest;
import com.mzm.Fitpin.exception.CustomException;
import com.mzm.Fitpin.service.MemberBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/members")
public class MemberBasicInfoController {

    @Autowired
    private MemberBasicInfoService memberBasicInfoService;

    @PostMapping("/basicInfo/{userEmail}")
    public ResponseEntity<?> updateBasicInfo(@PathVariable String userEmail, @RequestBody MemberBasicInfoRequest memberBasicInfoRequest) {
        try {
            memberBasicInfoService.updateBasicInfoWithStyles(userEmail, memberBasicInfoRequest);
            return ResponseEntity.ok().body(Collections.singletonMap("message", "선호 스타일 등록 완료!"));
        } catch (CustomException e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "예상치 못한 오류가 발생했습니다."));
        }
    }
}
