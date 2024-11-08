package com.mzm.Fitpin.controller.app.cart;

import com.mzm.Fitpin.dto.cart.CartDTO;
import com.mzm.Fitpin.dto.pit.PitItemCartDTO;
import com.mzm.Fitpin.mapper.cart.CartStoreGetMapper;
import com.mzm.Fitpin.mapper.pit.PitItemCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartStoreGetController {

    @Autowired
    private CartStoreGetMapper cartStoreGetMapper;

    @Autowired
    private PitItemCartMapper pitItemCartMapper;

    @GetMapping("/get-store/{userEmail}")
    public ResponseEntity<?> getCartByUserEmail(@PathVariable String userEmail) {
        try {
            List<CartDTO> cartItems = cartStoreGetMapper.findCartByUserEmail(userEmail);
            if (cartItems.isEmpty()) {
                return ResponseEntity.status(404).body(Collections.singletonMap("message", "장바구니가 비어 있습니다."));
            }
            for (CartDTO cartItem : cartItems) {
                if (cartItem.isPitStatus()) {
                    PitItemCartDTO pitItemCart = pitItemCartMapper.findPitItemByCartKey(cartItem.getCartKey());
                    cartItem.setPitItemCart(pitItemCart);  // 수선 정보 설정
                }
            }
            return ResponseEntity.ok(cartItems);

        } catch (Exception e) {
            e.getStackTrace();
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "장바구니 조회 중 오류가 발생했습니다."));
        }
    }
}
