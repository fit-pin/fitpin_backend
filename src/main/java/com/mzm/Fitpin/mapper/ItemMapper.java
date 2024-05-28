package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.entity.Item;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {
        void insertItem(Item item);
}
