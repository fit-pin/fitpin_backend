package com.mzm.Fitpin.controller;


import com.mzm.Fitpin.dto.UserPreferStyleDTO;
import com.mzm.Fitpin.entity.UserPreferStyle;
import com.mzm.Fitpin.service.UserPreferStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userPreferStyle")
public class UserPreferStyleController {
    @Autowired
    private UserPreferStyleService userPreferStyleService;

    @PostMapping
    public void insertUserPreferStyle(@RequestBody UserPreferStyleDTO userPreferStyleDTO) {
        UserPreferStyle userPreferStyle = new UserPreferStyle();
        userPreferStyle.setUserKey(userPreferStyleDTO.getUserKey());
        userPreferStyle.setPreferStyle(userPreferStyleDTO.getPreferStyle());
        userPreferStyleService.insertUserPreferStyle(userPreferStyle);
    }
}

