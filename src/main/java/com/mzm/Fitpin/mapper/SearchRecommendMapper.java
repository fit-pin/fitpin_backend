package com.mzm.Fitpin.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchRecommendMapper {

    // 검색 횟수가 높은 상위 10개의 검색어 조회
    List<String> getTopSearchWords();
}
