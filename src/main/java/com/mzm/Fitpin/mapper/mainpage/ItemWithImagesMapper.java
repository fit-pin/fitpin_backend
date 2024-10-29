package com.mzm.Fitpin.mapper.mainpage;

import com.mzm.Fitpin.dto.mainpage.ItemWithImagesDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemWithImagesMapper {
    List<ItemWithImagesDTO> findItemsWithImagesByType(@Param("itemType") String itemType);
}
