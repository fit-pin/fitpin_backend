package com.mzm.Fitpin.controller.web;

import com.mzm.Fitpin.entity.ItemTopInfo;
import com.mzm.Fitpin.mapper.ItemTopInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
//사용법 작성 해야함.
@RestController
@RequestMapping("/api/itemTopInfo")
public class ItemTopInfoController {

    @Autowired
    private ItemTopInfoMapper itemTopInfoMapper;

    @PostMapping("/register")
    public ResponseEntity<?> registerItemTopInfo(@RequestBody ItemTopInfo itemTopInfo) {
        try {
            itemTopInfoMapper.insert(itemTopInfo);
            return ResponseEntity.ok(Collections.singletonMap("message", "상의 상품 정보 등록 성공"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("message", "상의 상품 정보 등록 실패: " + e.getMessage()));
        }
    }
}
