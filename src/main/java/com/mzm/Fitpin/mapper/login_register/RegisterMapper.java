package com.mzm.Fitpin.mapper.login_register;

import com.mzm.Fitpin.entity.login_register.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
    void insertMember(Member member);

    void deleteMember(String userEmail); // 회원탈퇴를 위한 메소드 추가
}
