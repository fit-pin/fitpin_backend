package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.entity.ItemInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemInfoMapper {
    ItemInfo getItemInfoById(Integer itemKey);
}
