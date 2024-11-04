package com.mzm.Fitpin.controller.app.cart;

import com.mzm.Fitpin.dto.cart.CartDTO;
import com.mzm.Fitpin.mapper.cart.CartMapper;
import com.mzm.Fitpin.mapper.PitMapper;
import org.springframework.transaction.annotation.Transactional;
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
    @Autowired
    private PitMapper pitMapper;


    @Transactional
    @PostMapping("/store")
    public ResponseEntity<?> addItemToCart(@RequestBody CartDTO cartDTO) {
        try {
            // 장바구니에 기본 아이템 정보 삽입 및 cartKey 생성
            cartMapper.insertCart(cartDTO);
            System.out.println("Generated cartKey: " + cartDTO.getCartKey());

            // 수선 여부 및 아이템 타입에 따른 수선 정보 처리
            if (cartDTO.isPitStatus()) {
                if ("상의".equals(cartDTO.getItemType()) && cartDTO.getPitTopInfo() != null) {
                    cartDTO.getPitTopInfo().setCartKey(cartDTO.getCartKey());  // cartKey 설정
                    cartDTO.getPitTopInfo().setItemKey(cartDTO.getItemKey());  // itemKey 설정
                    pitMapper.insertPitTop(cartDTO.getPitTopInfo());
                }
            }else if ("하의".equals(cartDTO.getItemType()) && cartDTO.getPitBottomInfo() != null) {
                cartDTO.getPitBottomInfo().setCartKey(cartDTO.getCartKey());  // cartKey 설정
                cartDTO.getPitBottomInfo().setItemKey(cartDTO.getItemKey());  // itemKey 설정
                pitMapper.insertPitBottom(cartDTO.getPitBottomInfo());
            }


            return ResponseEntity.ok(Collections.singletonMap("message", "장바구니에 상품이 성공적으로 추가되었습니다."));

        } catch (Exception e) {
            e.printStackTrace();  // 오류 상세 출력
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
