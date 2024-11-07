package com.mzm.Fitpin.mapper.cart;

import com.mzm.Fitpin.dto.cart.CartDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {

    void insertCart(CartDTO cartDTO);

    int deleteCartItem(int cartKey);

}
