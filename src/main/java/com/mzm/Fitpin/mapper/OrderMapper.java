package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    void insertOrder(Order order);
}
