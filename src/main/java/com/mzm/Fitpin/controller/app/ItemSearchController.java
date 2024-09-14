package com.mzm.Fitpin.controller.app;

import com.mzm.Fitpin.entity.Item;
import com.mzm.Fitpin.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/item-search")
public class ItemSearchController {

    @Autowired
    private ItemSearchService itemSearchService;

    @GetMapping("/search/{searchWord}")
    public ResponseEntity<?> searchItem(@PathVariable String searchWord) {
        try {
            // 서비스 계층 호출하여 검색 처리
            List<Item> searchResults = itemSearchService.searchItems(searchWord);

            // 검색 결과 반환
            return ResponseEntity.ok().body(Collections.singletonMap("searchResult", searchResults));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "검색 중 오류가 발생했습니다."));
        }
    }
}
