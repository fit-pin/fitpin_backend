package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.entity.Item;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemDetailsMapper {
    Item getItemDetailsById(Integer itemKey);
}
