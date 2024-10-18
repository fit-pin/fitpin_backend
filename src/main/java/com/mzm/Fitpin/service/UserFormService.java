package com.mzm.Fitpin.service;

import com.mzm.Fitpin.dto.login_register.UserFormDto;
import com.mzm.Fitpin.entity.login_register.UserForm;
import com.mzm.Fitpin.mapper.login_register.UserFormMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserFormService {

    @Autowired
    private UserFormMapper userFormMapper;

    @Transactional
    public void saveUserForm(UserFormDto userFormDto) {
        UserForm userForm = new UserForm();
        userForm.setUserEmail(userFormDto.getUserEmail());
        userForm.setFileName(userFormDto.getFileName());
        userForm.setArmSize(userFormDto.getArmSize());
        userForm.setShoulderSize(userFormDto.getShoulderSize());
        userForm.setBodySize(userFormDto.getBodySize());
        userForm.setLegSize(userFormDto.getLegSize());

        userFormMapper.insertUserForm(userForm);
    }

    @Transactional(readOnly = true)
    public String getFileNameByUserEmail(String userEmail) {
        return userFormMapper.findFileNameByUserEmail(userEmail);
    }
}
