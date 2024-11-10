package com.mzm.Fitpin.mapper.fitStorage;

import com.mzm.Fitpin.entity.FitStorage;
import com.mzm.Fitpin.dto.FitStorageDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FitStorageMapper {
    // 이미지 삽입
    void insert(FitStorage fitStorage);

    // 사용자 이메일로 이미지 리스트 조회
    List<FitStorage> findByUserEmail(String userEmail);

    // 이미지 이름으로 이미지 삭제
    void deleteByFitStorageImg(String fitStorageImg); // fitStorageImg로 변경

    // 사용자 이메일과 이미지 이름으로 데이터 검색
    FitStorage findByUserEmailAndFitStorageImg(String userEmail, String fitStorageImg);

    void update_DeleteStatus(String userEmail, String fitStorageImg);

    List<FitStorage> findAllFitComments();

    FitStorageDTO findByFitCommentKey( int fitStorageKey);

    void deleteByFitStorageKey(int fitStorageKey); //진짜 삭제

    void update(FitStorage fitStorage);


}
