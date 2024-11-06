package com.mzm.Fitpin.mapper.order;

import com.mzm.Fitpin.dto.order.PitItemOrderDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PitItemOrderMapper {
    void insertPitItemOrder(PitItemOrderDTO pitItemOrderDTO);
  //수선 내역 가져오기
    PitItemOrderDTO getPitItemOrderByOrderKey(int orderKey);

}