package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemSearchMapper {
    List<Item> searchItems(String query);
}
