package com.mzm.Fitpin.controller.app.order;

import com.mzm.Fitpin.dto.order.OrderDTO;
import com.mzm.Fitpin.mapper.order.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping("/post_order")
    public ResponseEntity<?> postOrder(@RequestBody OrderDTO OrderDTO) {
        try {
            orderMapper.insertOrder(OrderDTO);
            return ResponseEntity.ok(Collections.singletonMap("message", "주문 등록 완료."));
        } catch (Exception e){
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "알수없는 오류가 발생했습니다."));
        }
    }

    @GetMapping("/get_order/{userKey}")
    public ResponseEntity<?> getOrder(@PathVariable String userKey) {
        try {
            List<OrderDTO> OrderLists = orderMapper.getOrderByUserKey(userKey);
            if (OrderLists.isEmpty()) {
                return ResponseEntity.status(404).body(Collections.singletonMap("message", "주문 리스트가 없습니다."));
            }
            return ResponseEntity.ok(OrderLists);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "주문 조회중 오류가 발생했습니다."));
        }

    }
}
