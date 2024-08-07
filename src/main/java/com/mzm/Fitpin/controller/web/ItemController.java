package com.mzm.Fitpin.controller.web;

import com.mzm.Fitpin.entity.Item;
import com.mzm.Fitpin.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
//사용법 작성 해야함
@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemMapper itemMapper;

    @PostMapping("/register")
    public ResponseEntity<?> registerItem(@RequestBody Item item) {
        try {
            itemMapper.insert(item);
            return ResponseEntity.ok(Collections.singletonMap("message", "상품 등록 성공"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("message", "상품 등록 실패: " + e.getMessage()));
        }
    }
}
