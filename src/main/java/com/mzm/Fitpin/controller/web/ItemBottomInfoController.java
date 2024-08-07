package com.mzm.Fitpin.controller.web;

import com.mzm.Fitpin.entity.ItemBottomInfo;
import com.mzm.Fitpin.mapper.ItemBottomInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
//사용법 작성 해야함
@RestController
@RequestMapping("/api/itemBottomInfo")
public class ItemBottomInfoController {

    @Autowired
    private ItemBottomInfoMapper itemBottomInfoMapper;

    @PostMapping("/register")
    public ResponseEntity<?> registerItemBottomInfo(@RequestBody ItemBottomInfo itemBottomInfo) {
        try {
            itemBottomInfoMapper.insert(itemBottomInfo);
            return ResponseEntity.ok(Collections.singletonMap("message", "하의 상품 정보 등록 성공"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("message", "하의 상품 정보 등록 실패: " + e.getMessage()));
        }
    }
}
