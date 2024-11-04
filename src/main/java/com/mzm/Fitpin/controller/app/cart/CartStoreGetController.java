package com.mzm.Fitpin.controller.app.cart;


import com.mzm.Fitpin.dto.PitBottomDTO;
import com.mzm.Fitpin.dto.PitTopDTO;
import com.mzm.Fitpin.dto.cart.CartDTO;
import com.mzm.Fitpin.mapper.cart.CartStoreGetMapper;
import com.mzm.Fitpin.mapper.PitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

//TODO: 수선내역 조회와 API를 통합 해야함.

@RestController // 이 클래스는 RESTful API의 컨트롤러임을 나타냄
@RequestMapping("/api/cart") // 이 컨트롤러의 기본 URL을 설정
public class CartStoreGetController {

    @Autowired // CartStoreGetMapper를 자동으로 주입 (의존성 주입)
    private CartStoreGetMapper cartStoreGetMapper;

    @Autowired
    private PitMapper pitMapper;

    // 특정 사용자의 이메일을 기반으로 장바구니 정보를 가져오는 GET 요청을 처리
    @GetMapping("/get-store/{userEmail}") //
    public ResponseEntity<?> getCartByUserEmail(@PathVariable String userEmail) {
        try {
            // Mapper를 사용하여 사용자 이메일로 장바구니 정보를 가져옴
            List<CartDTO> cartItems = cartStoreGetMapper.findCartByUserEmail(userEmail);
            if (cartItems.isEmpty()) { //장바구니가 비어있을 시 404 코드를 반환
                return ResponseEntity.status(404).body(Collections.singletonMap("message", "장바구니가 비어 있습니다."));
            }
            for (CartDTO cartItem : cartItems) {
                if (cartItem.isPitStatus()) {
                    if ("상의".equals(cartItem.getItemType())) {
                        PitTopDTO pitTop = pitMapper.findPitTopByCartKey(cartItem.getCartKey());
                        cartItem.setPitTopInfo(pitTop);
                    } else if ("하의".equals(cartItem.getItemType())) {
                        PitBottomDTO pitBottom = pitMapper.findPitBottomByCartKey(cartItem.getCartKey());
                        cartItem.setPitBottomInfo(pitBottom);
                    }
                }
            }
                // 장바구니 정보를 정상적으로 조회한 경우 200 OK 응답과 함께 데이터를 반환
                return ResponseEntity.ok(cartItems);

        } catch (Exception e) {
            // 예외가 발생한 경우 500 서버 오류와 함께 에러 메시지를 반환
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "장바구니 조회 중 오류가 발생했습니다."));
        }
    }
}
