package com.mzm.Fitpin.service;


import com.mzm.Fitpin.entity.UserPreferStyle;
import com.mzm.Fitpin.mapper.UserPreferStyleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPreferStyleService {
    @Autowired
    private UserPreferStyleMapper userPreferStyleMapper;

    public void insertUserPreferStyle(UserPreferStyle userPreferStyle) {
        userPreferStyleMapper.insertUserPreferStyle(userPreferStyle);
    }
}