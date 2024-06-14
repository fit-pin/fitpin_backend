package com.mzm.Fitpin.controller;

import com.mzm.Fitpin.entity.Item;
import com.mzm.Fitpin.dto.ItemDetailsResponse;
import com.mzm.Fitpin.service.ItemDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//특정 상품의 상세 정보를 조회하는 GET 메서드 입니다.
@RestController
@RequestMapping("/api/itemdetails")
public class ItemDetailsController {
    @Autowired
    private ItemDetailsService itemDetailsService;

    @GetMapping("/{itemKey}")
    public ResponseEntity<ItemDetailsResponse> getItemDetailsById(@PathVariable Integer itemKey) {
        Item item = itemDetailsService.getItemDetailsById(itemKey);
        ItemDetailsResponse response = new ItemDetailsResponse();

        if (item != null) {
            response.setItemKey(item.getItemKey());
            response.setItemNum(item.getItemNum());
            response.setItemName(item.getItemName());
            response.setItemType(item.getItemType());
            response.setItemBrand(item.getItemBrand());
            response.setItemImg1(item.getItemImg1());
            response.setItemImg2(item.getItemImg2());
            response.setItemImg3(item.getItemImg3());
            response.setItemCnt(item.getItemCnt());
            response.setItemSize(item.getItemSize());
            response.setItemContent(item.getItemContent());
            response.setItemPrice(item.getItemPrice());
            response.setItemDate(item.getItemDate());
        }

        return ResponseEntity.ok(response);
    }
}
