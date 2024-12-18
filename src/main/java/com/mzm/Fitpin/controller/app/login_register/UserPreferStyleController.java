package com.mzm.Fitpin.controller.app.login_register;

import com.mzm.Fitpin.dto.login_register.UserPreferStyleDTO;
import com.mzm.Fitpin.service.UserPreferStyleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//살리기
@RestController
@RequestMapping("/api")
public class UserPreferStyleController {
    private static final Logger logger = LoggerFactory.getLogger(UserPreferStyleController.class);

    @Autowired
    private UserPreferStyleService userPreferStyleService;

    @PostMapping("/userPreferStyle")
    public ResponseEntity<String> insertUserPreferStyles(@RequestBody List<UserPreferStyleDTO> userPreferStyleDTOs) {
        List<UserPreferStyleDTO> registeredStyles = userPreferStyleService.insertUserPreferStyles(userPreferStyleDTOs);
        StringBuilder responseMessage = new StringBuilder("선호 스타일 등록 완료: ");

        for (UserPreferStyleDTO style : registeredStyles) {
            responseMessage.append(style.getPreferStyle()).append(", ");
        }

        // Remove the last comma and space
        if (responseMessage.length() > 0) {
            responseMessage.setLength(responseMessage.length() - 2);
        }

        // Log the registered styles
        logger.info("선호 스타일 등록 {}: {}", userPreferStyleDTOs.get(0).getUserEmail(), responseMessage.toString());

        return ResponseEntity.ok(responseMessage.toString());
    }

    @GetMapping("/GetUserPreferStyle/{userEmail}")
    public ResponseEntity<List<UserPreferStyleDTO>> getUserPreferStyles(@PathVariable String userEmail) {
        List<UserPreferStyleDTO> userPreferStyles = userPreferStyleService.getUserPreferStylesByEmail(userEmail);
        return ResponseEntity.ok(userPreferStyles);
    }
}
