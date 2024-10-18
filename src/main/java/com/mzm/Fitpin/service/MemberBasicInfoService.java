package com.mzm.Fitpin.service;

import com.mzm.Fitpin.dto.login_register.MemberBasicInfoRequest;
import com.mzm.Fitpin.dto.login_register.UserPreferStyleDTO;
import com.mzm.Fitpin.entity.login_register.Member;
import com.mzm.Fitpin.entity.login_register.UserPreferStyle;
import com.mzm.Fitpin.exception.CustomException;
import com.mzm.Fitpin.mapper.login_register.MemberBasicInfoMapper;
import com.mzm.Fitpin.mapper.login_register.UserPreferStyleMapper;
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

            try {
                userPreferStyleMapper.insertUserPreferStyle(userPreferStyle);
            } catch (Exception e) {
                throw new CustomException("중복된 선호 스타일: " + styleDTO.getPreferStyle());
            }
        }
    }
}
