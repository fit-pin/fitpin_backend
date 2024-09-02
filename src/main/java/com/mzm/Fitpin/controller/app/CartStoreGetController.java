package com.mzm.Fitpin.controller.app;

import com.mzm.Fitpin.dto.CartDTO;
import com.mzm.Fitpin.mapper.CartStoreGetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartStoreGetController {

    @Autowired
    private CartStoreGetMapper cartStoreGetMapper;

    @GetMapping("/get-store/{userEmail}")
    public ResponseEntity<?> getCartByUserEmail(@PathVariable String userEmail) {
        try {
            List<CartDTO> cartItems = cartStoreGetMapper.findCartByUserEmail(userEmail);
            return ResponseEntity.ok(cartItems);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "장바구니 조회 중 오류가 발생했습니다."));
        }
    }
}
