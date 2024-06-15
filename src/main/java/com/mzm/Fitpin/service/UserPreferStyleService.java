package com.mzm.Fitpin.service;

import com.mzm.Fitpin.dto.UserPreferStyleDTO;
import com.mzm.Fitpin.entity.UserPreferStyle;
import com.mzm.Fitpin.mapper.UserPreferStyleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPreferStyleService {
    @Autowired
    private UserPreferStyleMapper userPreferStyleMapper;

    public List<UserPreferStyleDTO> insertUserPreferStyles(List<UserPreferStyleDTO> userPreferStyleDTOs) {
        List<UserPreferStyleDTO> registeredStyles = new ArrayList<>();
        for (UserPreferStyleDTO dto : userPreferStyleDTOs) {
            UserPreferStyle userPreferStyle = new UserPreferStyle();
            userPreferStyle.setUserEmail(dto.getUserEmail());
            userPreferStyle.setPreferStyle(dto.getPreferStyle());
            userPreferStyleMapper.insertUserPreferStyle(userPreferStyle);
            registeredStyles.add(dto);
        }
        return registeredStyles;
    }

    public List<UserPreferStyleDTO> getUserPreferStylesByEmail(String userEmail) {
        List<UserPreferStyle> userPreferStyles = userPreferStyleMapper.findUserPreferStylesByEmail(userEmail);
        List<UserPreferStyleDTO> userPreferStyleDTOs = new ArrayList<>();
        for (UserPreferStyle userPreferStyle : userPreferStyles) {
            UserPreferStyleDTO dto = new UserPreferStyleDTO();
            dto.setUserEmail(userPreferStyle.getUserEmail());
            dto.setPreferStyle(userPreferStyle.getPreferStyle());
            userPreferStyleDTOs.add(dto);
        }
        return userPreferStyleDTOs;
    }
}
