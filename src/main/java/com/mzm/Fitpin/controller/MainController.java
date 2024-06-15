package com.mzm.Fitpin.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MainController {
    
    @GetMapping("/")
    public String getMethodName() {
        return new String("Server Run");
    }
    
}
