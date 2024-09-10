package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.entity.FitStorage;
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
}
