package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.dto.UserBodyInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserBodyInfoMapper {

    UserBodyInfoDTO getUserBodyInfoByEmail(String userEmail);
}
