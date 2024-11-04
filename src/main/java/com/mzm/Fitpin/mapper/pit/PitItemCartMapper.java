package com.mzm.Fitpin.mapper.pit;

import com.mzm.Fitpin.dto.pit.PitItemCartDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PitItemCartMapper {

    void insertPitItemCart(PitItemCartDTO pitItemCartDTO);

    PitItemCartDTO findPitItemByCartKey(int cartKey);

}
