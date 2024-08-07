package com.mzm.Fitpin.controller.app;

import com.mzm.Fitpin.dto.UserBodyInfoDTO;
import com.mzm.Fitpin.service.UserBodyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//살리기?
@RestController
@RequestMapping("/api")
public class UserBodyInfoController {

    @Autowired
    private UserBodyInfoService userBodyInfoService;

    @GetMapping("/userbodyinfo/{userEmail}")
    public ResponseEntity<UserBodyInfoDTO> getUserBodyInfo(@PathVariable String userEmail) {
        UserBodyInfoDTO userBodyInfo = userBodyInfoService.getUserBodyInfoByEmail(userEmail);
        return ResponseEntity.ok(userBodyInfo);
    }
}
