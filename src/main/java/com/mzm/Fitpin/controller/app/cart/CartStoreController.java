package com.mzm.Fitpin.controller.app.cart;

import com.mzm.Fitpin.dto.cart.CartDTO;
import com.mzm.Fitpin.mapper.cart.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

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

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteItemFromCart(@RequestBody Map<String, Object> deleteRequest) {
        try {
            String userEmail = (String) deleteRequest.get("userEmail");
            int itemKey = (int) deleteRequest.get("itemKey");

            int deletedRows = cartMapper.deleteCartItem(userEmail, itemKey);
            if (deletedRows > 0) {
                return ResponseEntity.ok(Collections.singletonMap("message", "장바구니에서 상품이 성공적으로 삭제되었습니다."));
            } else {
                return ResponseEntity.status(404).body(Collections.singletonMap("message", "해당 상품을 찾을 수 없습니다."));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "장바구니에서 상품 삭제 중 오류가 발생했습니다."));
        }
    }
}
