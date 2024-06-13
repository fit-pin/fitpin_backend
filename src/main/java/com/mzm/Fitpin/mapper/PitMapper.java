package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.entity.PitBottom;
import com.mzm.Fitpin.entity.PitTop;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PitMapper {
    void insertPitTop(PitTop pitTop);
    void insertPitBottom(PitBottom pitBottom);
}
