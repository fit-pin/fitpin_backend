package com.mzm.Fitpin.mapper.login_register;

import com.mzm.Fitpin.entity.login_register.UserPreferStyle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserPreferStyleMapper {
    void insertUserPreferStyle(UserPreferStyle userPreferStyle);
    List<UserPreferStyle> findUserPreferStylesByEmail(String userEmail);
}
