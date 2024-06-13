package com.mzm.Fitpin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//하의 크기 조회용 api입니다
@RestController
@RequestMapping("/api/itembottomsize")
public class ItemBottomSizeController {
    @Autowired
    private ItemBottomSizeService itemBottomSizeService;

    @GetMapping("/{itemKey}")
    public ResponseEntity<List<ItemBottomSize>> getItemBottomSizesByItemKey(@PathVariable Integer itemKey) {
        List<ItemBottomSize> itemBottomSizes = itemBottomSizeService.getItemBottomSizesByItemKey(itemKey);
        return ResponseEntity.ok(itemBottomSizes);
    }
}
