package com.mzm.Fitpin.dto.order;

import lombok.Data;
import java.util.List;

@Data
public class OrderRequestDTO {
    private String userEmail;
    private String userName;
    private String userAddr;
    private String userAddrDetail;
    private String userNumber;
    private int itemTotal;
    private String optional;
    private List<ItemOrderDTO> items; // 여러 상품 정보를 포함한 리스트
}
