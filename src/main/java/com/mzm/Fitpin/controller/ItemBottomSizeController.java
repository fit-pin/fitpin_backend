package com.mzm.Fitpin.controller;

import com.mzm.Fitpin.entity.ItemBottomSize;
import com.mzm.Fitpin.service.ItemBottomSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
