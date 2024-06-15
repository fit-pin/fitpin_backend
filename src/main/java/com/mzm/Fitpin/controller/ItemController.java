package com.mzm.Fitpin.controller;

import com.mzm.Fitpin.dto.ItemPostRequest;
import com.mzm.Fitpin.entity.Item;
import com.mzm.Fitpin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// /api/items/{itemkey} 상품을 등록하기 위한 POST 메서드 입니다,
@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Void> createItem(@RequestBody ItemPostRequest itemPostRequest) {
        Item item = new Item();
        item.setItemKey(itemPostRequest.getItemKey());
        item.setItemNum(itemPostRequest.getItemNum());
        item.setItemName(itemPostRequest.getItemName());
        item.setItemType(itemPostRequest.getItemType());
        item.setItemBrand(itemPostRequest.getItemBrand());
        item.setItemImg1(itemPostRequest.getItemImg1());
        item.setItemImg2(itemPostRequest.getItemImg2());
        item.setItemImg3(itemPostRequest.getItemImg3());
        item.setItemCnt(itemPostRequest.getItemCnt());
        item.setItemSize(itemPostRequest.getItemSize());
        item.setItemContent(itemPostRequest.getItemContent());
        item.setItemPrice(itemPostRequest.getItemPrice());
        item.setItemDate(itemPostRequest.getItemDate());

        itemService.addItem(item);
        return ResponseEntity.ok().build();
    }
}
