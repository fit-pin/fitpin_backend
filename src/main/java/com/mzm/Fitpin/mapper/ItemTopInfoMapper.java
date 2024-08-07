package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.entity.ItemTopInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemTopInfoMapper {
    void insert(ItemTopInfo itemTopInfo);
}
