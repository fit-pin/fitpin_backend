package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.entity.UserPreferStyle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserPreferStyleMapper {
    void insertUserPreferStyle(UserPreferStyle userPreferStyle);
    List<UserPreferStyle> findUserPreferStylesByEmail(String userEmail);
}
