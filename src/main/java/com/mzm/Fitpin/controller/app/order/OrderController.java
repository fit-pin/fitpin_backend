package com.mzm.Fitpin.controller.app.order;

import com.mzm.Fitpin.dto.order.ItemOrderDTO;
import com.mzm.Fitpin.dto.order.OrderDTO;
import com.mzm.Fitpin.dto.order.OrderRequestDTO;
import com.mzm.Fitpin.dto.order.PitItemOrderDTO;
import com.mzm.Fitpin.mapper.ItemImgMapper;
import com.mzm.Fitpin.mapper.order.OrderMapper;
import com.mzm.Fitpin.mapper.order.PitItemOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ItemImgMapper itemImgMapper;

    @Autowired
    private PitItemOrderMapper pitItemOrderMapper; // 새로 추가된 매퍼

    @PostMapping("/post_order") // 여러 상품을 포함한 주문 등록
    public ResponseEntity<?> postOrder(@RequestBody OrderRequestDTO orderRequest) {
        try {
            for (ItemOrderDTO item : orderRequest.getItems()) {
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setUserEmail(orderRequest.getUserEmail());
                orderDTO.setUserName(orderRequest.getUserName());
                orderDTO.setUserAddr(orderRequest.getUserAddr());
                orderDTO.setUserAddrDetail(orderRequest.getUserAddrDetail());
                orderDTO.setUserNumber(orderRequest.getUserNumber());
                orderDTO.setItemKey(item.getItemKey());
                orderDTO.setItemSize(item.getItemSize());
                orderDTO.setItemPrice(item.getItemPrice());
                orderDTO.setQty(item.getQty());
                orderDTO.setItemTotal(orderRequest.getItemTotal());
                orderDTO.setPitStatus(item.isPitStatus());

                String itemImgName = itemImgMapper.getItemImgNameByItemKey(item.getItemKey());
                orderDTO.setItemImg(itemImgName);

                orderMapper.insertOrder(orderDTO);

                if (item.isPitStatus() && item.getPitItemOrder() != null) {
                    item.getPitItemOrder().setOrderKey(orderDTO.getOrderKey());
                    item.getPitItemOrder().setItemKey(item.getItemKey());
                    item.getPitItemOrder().setItemName(item.getItemName()); // itemName 필드 추가
                    pitItemOrderMapper.insertPitItemOrder(item.getPitItemOrder());
                }
            }

            return ResponseEntity.ok(Collections.singletonMap("message", "주문 등록 완료."));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "알 수 없는 오류가 발생했습니다."));
        }
    }


    @GetMapping("/get_order/{userEmail}") // 주문 조회
    public ResponseEntity<?> getOrder(@PathVariable String userEmail) {
        try {
            // 사용자 이메일을 기반으로 주문 목록 조회
            List<OrderDTO> orderLists = orderMapper.getOrderByUserKey(userEmail);
            if (orderLists.isEmpty()) {
                return ResponseEntity.status(404).body(Collections.singletonMap("message", "주문 리스트가 없습니다."));
            }

            // 조건에 따른 필드 수정 및 수선 정보 추가 로직
            List<OrderDTO> processedOrders = orderLists.stream().map(order -> {
                // 수선 여부 처리 (0: false, 1: true)
                order.setPitStatus(order.isPitStatus());

                // 수선 비용 처리 (null인 경우 "경매중")
                order.setDisplayPitPrice(Objects.isNull(order.getPitPrice()) ? "경매중" : String.valueOf(order.getPitPrice()));

                // 주문 상태 처리 (0: 결제 완료, 1: 배송중, 2: 배송완료)
                switch (order.getOrderStatus()) {
                    case 0:
                        order.setDisplayOrderStatus("결제 완료");
                        break;
                    case 1:
                        order.setDisplayOrderStatus("배송중");
                        break;
                    case 2:
                        order.setDisplayOrderStatus("배송완료");
                        break;
                    default:
                        order.setDisplayOrderStatus("알 수 없음");
                }

                // 수선 정보 추가: pitStatus가 true일 경우 pitItemOrder 테이블에서 정보 조회 및 설정
                if (order.isPitStatus()) {
                    PitItemOrderDTO pitItemOrder = pitItemOrderMapper.getPitItemOrderByOrderKey(order.getOrderKey());
                    order.setPitItemOrder(pitItemOrder);
                }

                return order;
            }).toList();

            return ResponseEntity.ok(processedOrders);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "주문 조회 중 오류가 발생했습니다."));
        }
    }


    @PutMapping("/update_status/{orderKey}") // 주문 상태 갱신 API
    public ResponseEntity<?> updateOrderStatus(@PathVariable int orderKey, @RequestParam int orderStatus) {
        try {
            int rowsAffected = orderMapper.updateOrderStatus(orderKey, orderStatus);
            if (rowsAffected > 0) {
                return ResponseEntity.ok(Collections.singletonMap("message", "주문 상태가 성공적으로 업데이트되었습니다."));
            } else {
                return ResponseEntity.status(404).body(Collections.singletonMap("message", "해당 주문을 찾을 수 없습니다."));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "주문 상태 업데이트 중 오류가 발생했습니다."));
        }
    }

    @PutMapping("/update_pitpirce/{orderKey}")// 수선 값 수정 api
    public ResponseEntity<?> updatePitPrice(@PathVariable int orderKey, @RequestBody OrderDTO orderDTO) {
        try {
            Integer pitPrice = orderDTO.getPitPrice();
            Integer orderStatus = orderDTO.getOrderStatus();
            int rowsAffected = orderMapper.updatePitPrice(orderKey, pitPrice, orderStatus);

            if (rowsAffected > 0) {
                return ResponseEntity.ok(Collections.singletonMap("message", "수선값이 업데이트되었습니다."));
            } else {
                return ResponseEntity.status(404).body(Collections.singletonMap("message", "해당 주문을 찾을 수 없습니다."));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "수선값 업데이트 중 오류가 발생했습니다."));}

    }

}
