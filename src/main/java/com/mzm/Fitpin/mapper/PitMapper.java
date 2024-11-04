package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.dto.PitBottomDTO;
import com.mzm.Fitpin.dto.PitTopDTO;
import com.mzm.Fitpin.entity.PitBottom;
import com.mzm.Fitpin.entity.PitTop;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PitMapper {
    void insertPitTop(PitTopDTO pitTop);
    void insertPitBottom(PitBottomDTO pitBottom);
    PitTopDTO findPitTopByCartKey(int cartKey);
    PitBottomDTO findPitBottomByCartKey(int cartKey);
}
