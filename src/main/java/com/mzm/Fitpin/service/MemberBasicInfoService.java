package com.mzm.Fitpin.service;

import com.mzm.Fitpin.dto.MemberBasicInfoRequest;
import com.mzm.Fitpin.dto.UserPreferStyleDTO;
import com.mzm.Fitpin.entity.Member;
import com.mzm.Fitpin.entity.UserPreferStyle;
import com.mzm.Fitpin.mapper.MemberBasicInfoMapper;
import com.mzm.Fitpin.mapper.UserPreferStyleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberBasicInfoService {

    @Autowired
    private MemberBasicInfoMapper memberBasicInfoMapper;

    @Autowired
    private UserPreferStyleMapper userPreferStyleMapper;

    @Transactional
    public void updateBasicInfoWithStyles(String userEmail, MemberBasicInfoRequest memberBasicInfoRequest) {
        // Update basic info
        Member member = new Member();
        member.setUserEmail(userEmail);
        member.setUserGender(memberBasicInfoRequest.getUserGender());
        member.setUserHeight(memberBasicInfoRequest.getUserHeight());
        member.setUserWeight(memberBasicInfoRequest.getUserWeight());
        member.setUserFit(memberBasicInfoRequest.getUserFit());

        memberBasicInfoMapper.updateBasicInfo(member);

        // Insert user prefer styles
        for (UserPreferStyleDTO styleDTO : memberBasicInfoRequest.getStyle()) {
            UserPreferStyle userPreferStyle = new UserPreferStyle();
            userPreferStyle.setUserEmail(styleDTO.getUserEmail());
            userPreferStyle.setPreferStyle(styleDTO.getPreferStyle());
            userPreferStyleMapper.insertUserPreferStyle(userPreferStyle);
        }
    }
}
