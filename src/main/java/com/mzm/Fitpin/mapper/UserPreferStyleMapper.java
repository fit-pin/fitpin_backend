package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.entity.UserPreferStyle;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserPreferStyleMapper {
    void insertUserPreferStyle(UserPreferStyle userPreferStyle);
}
