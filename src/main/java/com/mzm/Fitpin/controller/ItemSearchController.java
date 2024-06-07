package com.mzm.Fitpin.controller;

import com.mzm.Fitpin.entity.Item;
import com.mzm.Fitpin.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
///api/search/{itemkey}, 검색 결과 조회 GET 메서드입니다, 검색 결과를 보여주기 위한 간략한 상품 정보를 반환합니다.
@RestController
@RequestMapping("/api/search")
public class ItemSearchController {

    @Autowired
    private ItemSearchService itemSearchService;

    @GetMapping
    public ResponseEntity<List<Item>> searchItems(@RequestParam String query) {
        List<Item> items = itemSearchService.searchItems(query);
        return ResponseEntity.ok(items);
    }
}
