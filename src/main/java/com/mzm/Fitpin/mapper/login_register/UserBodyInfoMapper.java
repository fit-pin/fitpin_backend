package com.mzm.Fitpin.mapper.login_register;

import com.mzm.Fitpin.dto.login_register.UserBodyInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserBodyInfoMapper {

    UserBodyInfoDTO getUserBodyInfoByEmail(String userEmail);
}
