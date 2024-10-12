package com.mzm.Fitpin.controller.app.order;

import com.mzm.Fitpin.dto.order.PaymentDTO;
import com.mzm.Fitpin.mapper.order.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentMapper paymentMapper;

    @PostMapping("/complete")
    public ResponseEntity<?> completePayment(@RequestBody PaymentDTO paymentDTO) {
        try {
            paymentMapper.insertPaymentDetails(paymentDTO);
            return ResponseEntity.ok(Collections.singletonMap("message", "결제 및 주문 내역 저장 완료."));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "결제 내역 저장 중 오류가 발생했습니다."));
        }
    }
}