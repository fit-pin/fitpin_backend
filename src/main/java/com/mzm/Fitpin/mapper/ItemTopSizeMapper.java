package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.entity.ItemTopSize;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemTopSizeMapper {
    List<ItemTopSize> getItemTopSizesByItemKey(Integer itemKey);
}
