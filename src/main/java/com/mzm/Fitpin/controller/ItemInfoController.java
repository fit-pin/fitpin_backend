package com.mzm.Fitpin.controller;

import com.mzm.Fitpin.entity.ItemInfo;
import com.mzm.Fitpin.service.ItemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/iteminfo")
public class ItemInfoController {
    @Autowired
    private ItemInfoService itemInfoService;

    @GetMapping("/{itemKey}")
    public ResponseEntity<ItemInfo> getItemInfoById(@PathVariable Integer itemKey) {
        ItemInfo itemInfo = itemInfoService.getItemInfoById(itemKey);
        if (itemInfo != null) {
            return ResponseEntity.ok(itemInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
