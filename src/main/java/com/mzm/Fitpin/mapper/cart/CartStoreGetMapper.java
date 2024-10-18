package com.mzm.Fitpin.mapper.cart;

import com.mzm.Fitpin.dto.cart.CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartStoreGetMapper {

    List<CartDTO> findCartByUserEmail(String userEmail);
}
