package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.entity.FitStorage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FitStorageMapper {
    void insert(FitStorage fitStorage);

    List<FitStorage> findByUserEmail(String userEmail);

    void deleteByImgURL(String imgURL);
}
