package com.mzm.Fitpin.mapper.order;

import com.mzm.Fitpin.dto.order.PaymentDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {

    // 결제 및 주문 내역을 paymentDetails 테이블에 저장하는 메소드
    void insertPaymentDetails(PaymentDTO paymentDTO);
}
