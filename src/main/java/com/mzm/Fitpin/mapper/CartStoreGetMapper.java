package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartStoreGetMapper {

    List<CartDTO> findCartByUserEmail(String userEmail);
}
