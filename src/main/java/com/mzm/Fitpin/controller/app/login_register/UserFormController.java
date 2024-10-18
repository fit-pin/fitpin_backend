package com.mzm.Fitpin.controller.app.login_register;

import com.mzm.Fitpin.dto.login_register.UserFormDto;
import com.mzm.Fitpin.service.UserFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
//살리기
@RestController
@RequestMapping("/api/userForm")
public class UserFormController {

    @Autowired
    private UserFormService userFormService;

    @PostMapping
    public ResponseEntity<?> saveUserForm(@RequestBody UserFormDto userFormDto) {
        try {
            userFormService.saveUserForm(userFormDto);
            return ResponseEntity.ok().body(Collections.singletonMap("message", "체형 정보 저장 완료"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "예상치 못한 오류가 발생했습니다."));
        }
    }

    @GetMapping("/{userEmail}")
    public ResponseEntity<?> getFileNameByUserEmail(@PathVariable String userEmail) {
        try {
            String fileName = userFormService.getFileNameByUserEmail(userEmail);
            return ResponseEntity.ok().body(Collections.singletonMap("fileName", fileName));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "예상치 못한 오류가 발생했습니다."));
        }
    }
}
