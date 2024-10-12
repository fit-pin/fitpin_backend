package com.mzm.Fitpin.mapper.order;

import com.mzm.Fitpin.dto.order.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface OrderMapper {

    void insertOrder(OrderDTO orderDTO);

    List<OrderDTO> getOrderByUserKey(String userKey);
}
