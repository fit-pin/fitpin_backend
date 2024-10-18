package com.mzm.Fitpin.mapper.login_register;

import com.mzm.Fitpin.entity.login_register.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberBasicInfoMapper {
    void updateBasicInfo(Member member);
}

