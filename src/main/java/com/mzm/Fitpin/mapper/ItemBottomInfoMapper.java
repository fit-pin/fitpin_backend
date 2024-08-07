package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.entity.ItemBottomInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemBottomInfoMapper {
    void insert(ItemBottomInfo itemBottomInfo);
}
