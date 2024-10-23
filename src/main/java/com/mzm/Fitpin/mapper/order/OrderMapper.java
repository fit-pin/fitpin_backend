package com.mzm.Fitpin.mapper.order;

import com.mzm.Fitpin.dto.order.OrderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface OrderMapper {

    void insertOrder(OrderDTO orderDTO);

    List<OrderDTO> getOrderByUserKey(String userEmail);

    int updateOrderStatus(@Param("orderKey") int orderKey, @Param("orderStatus") int orderStatus);
}
