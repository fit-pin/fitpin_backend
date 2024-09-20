package com.mzm.Fitpin.controller.app;

import com.mzm.Fitpin.mapper.SearchRecommendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/item-search/recommend")
public class ItemSearchRecommendController {

    @Autowired
    private SearchRecommendMapper searchRecommendMapper;

    @GetMapping
    public ResponseEntity<?> getRecommendList() {
        try {
            // 검색 횟수 기준 상위 5개의 검색어 조회
            List<String> recommendList = searchRecommendMapper.getTopSearchWords();

            // 상위 5개의 검색어 중에서 랜덤으로 3개를 선택
            Collections.shuffle(recommendList);
            List<String> randomThree = recommendList.subList(0, Math.min(recommendList.size(), 3));

            // 검색 결과 반환
            return ResponseEntity.ok().body(Collections.singletonMap("recommendations", randomThree));
        } catch (Exception e) {
            // 오류 처리
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "추천 검색어 조회 중 오류가 발생했습니다."));
        }
    }
}
