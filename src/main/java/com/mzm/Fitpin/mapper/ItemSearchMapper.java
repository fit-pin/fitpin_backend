package com.mzm.Fitpin.mapper;

import com.mzm.Fitpin.dto.ItemSearchDTO;
import com.mzm.Fitpin.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemSearchMapper {

    int checkSearchWordExists(String searchWord); // 검색어 존재 여부 확인

    void insertSearchWord(ItemSearchDTO itemSearchDTO); // 검색어 삽입

    void incrementSearchCount(String searchWord); // 검색어 카운트 증가

    List<Item> searchItems(String searchWord); // item 테이블에서 검색
}
