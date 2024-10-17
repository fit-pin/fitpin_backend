package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
    void insertMember(Member member);

    void deleteMember(String userEmail); // 회원탈퇴를 위한 메소드 추가
}
