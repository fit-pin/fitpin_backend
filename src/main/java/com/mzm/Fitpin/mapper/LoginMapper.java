package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    //@Select("SELECT * FROM member WHERE userEmail = #{userEmail}")
    Member findByUserEmail(String userEmail);
}
