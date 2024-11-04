package com.mzm.Fitpin.mapper.cart;

import com.mzm.Fitpin.dto.PitBottomDTO;
import com.mzm.Fitpin.dto.PitTopDTO;
import com.mzm.Fitpin.dto.cart.CartDTO;
import com.mzm.Fitpin.entity.PitBottom;
import com.mzm.Fitpin.entity.PitTop;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {

    void insertCart(CartDTO cartDTO);

    int deleteCartItem(String userEmail, int itemKey);

    void insertPitTop(PitTopDTO pitTopInfo);

    void insertPitBottom(PitBottomDTO pitBottomInfo);
}
