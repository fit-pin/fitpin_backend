package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.entity.ItemBottomSize;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemBottomSizeMapper {
    List<ItemBottomSize> getItemBottomSizesByItemKey(Integer itemKey);
}
