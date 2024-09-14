package com.mzm.Fitpin.service;

import com.mzm.Fitpin.dto.ItemSearchDTO;
import com.mzm.Fitpin.entity.Item;
import com.mzm.Fitpin.mapper.ItemSearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemSearchService {

    @Autowired
    private ItemSearchMapper itemSearchMapper;

    public List<Item> searchItems(String searchWord) throws Exception {
        // 검색어가 searchTable에 있는지 확인
        int count = itemSearchMapper.checkSearchWordExists(searchWord);

        if (count > 0) {
            // 검색어가 존재하면 카운트 증가
            itemSearchMapper.incrementSearchCount(searchWord);
        } else {
            // 검색어가 존재하지 않으면 새로운 검색어 삽입
            ItemSearchDTO newSearch = new ItemSearchDTO();
            newSearch.setSearchWord(searchWord);
            newSearch.setSearchCount(1);
            itemSearchMapper.insertSearchWord(newSearch);
        }

        // item 테이블에서 검색어에 맞는 항목 검색
        return itemSearchMapper.searchItems(searchWord);
    }
}
