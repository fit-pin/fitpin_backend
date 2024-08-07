package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.dto.UserBodyInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserBodyInfoMapper {

    UserBodyInfoDTO getUserBodyInfoByEmail(String userEmail);
}
