package com.mzm.Fitpin.mapper.login_register;

import com.mzm.Fitpin.entity.login_register.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    //@Select("SELECT * FROM member WHERE userEmail = #{userEmail}")
    Member findByUserEmail(String userEmail);
}
