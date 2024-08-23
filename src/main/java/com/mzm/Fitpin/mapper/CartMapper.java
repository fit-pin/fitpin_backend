package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {

    void insertCart(CartDTO cartDTO);

}
