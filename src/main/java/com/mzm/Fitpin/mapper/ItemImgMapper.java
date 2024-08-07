package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.entity.ItemImg;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemImgMapper {
    void insert(ItemImg itemImg);
    // 다른 CRUD 메소드들
    // ...
}
