package com.mzm.Fitpin.service;

import com.mzm.Fitpin.dto.login_register.UserBodyInfoDTO;
import com.mzm.Fitpin.mapper.login_register.UserBodyInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBodyInfoService {

    @Autowired
    private UserBodyInfoMapper userBodyInfoMapper;

    public UserBodyInfoDTO getUserBodyInfoByEmail(String userEmail) {
        return userBodyInfoMapper.getUserBodyInfoByEmail(userEmail);
    }
}
