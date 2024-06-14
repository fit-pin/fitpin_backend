package com.mzm.Fitpin.controller;

import com.mzm.Fitpin.entity.ItemTopSize;
import com.mzm.Fitpin.service.ItemTopSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//상의 상품의 사이즈를 조회하는 api입니다
@RestController
@RequestMapping("/api/itemtopsize")
public class ItemTopSizeController {
    @Autowired
    private ItemTopSizeService itemTopSizeService;

    @GetMapping("/{itemKey}")
    public ResponseEntity<List<ItemTopSize>> getItemTopSizesByItemKey(@PathVariable Integer itemKey) {
        List<ItemTopSize> itemTopSizes = itemTopSizeService.getItemTopSizesByItemKey(itemKey);
        return ResponseEntity.ok(itemTopSizes);
    }
}
