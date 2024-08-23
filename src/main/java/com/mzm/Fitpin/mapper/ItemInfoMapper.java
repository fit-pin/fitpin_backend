package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.dto.ItemBottomInfoDTO;
import com.mzm.Fitpin.dto.ItemInfoDTO;
import com.mzm.Fitpin.dto.ItemTopInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemInfoMapper {
    //@Select("SELECT itemKey, itemName, itemBrand, itemStyle, itemPrice FROM item WHERE itemKey = #{itemKey}")
    ItemInfoDTO findItemByKey(@Param("itemKey") int itemKey);

    //@Select("SELECT itemImgURL FROM ItemImg WHERE itemKey = #{itemKey}")
    List<String> findItemImages(@Param("itemKey") int itemKey);

    //@Select("SELECT * FROM itemTopInfo WHERE itemKey = #{itemKey}")
    ItemTopInfoDTO findTopInfoByKey(@Param("itemKey") int itemKey);

    //@Select("SELECT * FROM itemBottomInfo WHERE itemKey = #{itemKey}")
    ItemBottomInfoDTO findBottomInfoByKey(@Param("itemKey") int itemKey);
}
