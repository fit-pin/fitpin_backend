package com.mzm.Fitpin.controller.app;

import com.mzm.Fitpin.dto.CartDTO;
import com.mzm.Fitpin.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/cart")
public class CartStoreController {

    @Autowired
    private CartMapper cartMapper;

    @PostMapping("/store")
    public ResponseEntity<?> addItemToCart(@RequestBody CartDTO cartDTO) {
        try {
            cartMapper.insertCart(cartDTO);
            return ResponseEntity.ok(Collections.singletonMap("message", "장바구니에 상품이 성공적으로 추가되었습니다."));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "장바구니에 상품 추가 중 오류가 발생했습니다."));
        }
    }
}
