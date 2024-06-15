package com.mzm.Fitpin.service;

import com.mzm.Fitpin.dto.MemberBasicInfoRequest;
import com.mzm.Fitpin.entity.Member;
import com.mzm.Fitpin.mapper.MemberBasicInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberBasicInfoService {
    @Autowired
    private MemberBasicInfoMapper memberBasicInfoMapper;

    public void updateBasicInfo(String userEmail, MemberBasicInfoRequest memberBasicInfoRequest) {
        Member member = new Member();
        member.setUserEmail(userEmail);
        member.setUserGender(memberBasicInfoRequest.getUserGender());
        member.setUserHeight(memberBasicInfoRequest.getUserHeight());
        member.setUserWeight(memberBasicInfoRequest.getUserWeight());

        memberBasicInfoMapper.updateBasicInfo(member);
    }
}
