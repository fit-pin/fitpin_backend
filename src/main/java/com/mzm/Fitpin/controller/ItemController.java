package com.mzm.Fitpin.controller;

import com.mzm.Fitpin.entity.Item;
import com.mzm.Fitpin.post.ItemPostRequest;
import com.mzm.Fitpin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        item.setItemImg1(itemPostRequest.getItemImg1());
        item.setItemImg2(itemPostRequest.getItemImg2());
        item.setItemImg3(itemPostRequest.getItemImg3());
        item.setItemContent(itemPostRequest.getItemContent());
        item.setItemPrice(itemPostRequest.getItemPrice());
        item.setItemSale(itemPostRequest.getItemSale());
        item.setItemCnt(itemPostRequest.getItemCnt());
        item.setItemDate(itemPostRequest.getItemDate());

        itemService.addItem(item);
        return ResponseEntity.ok().build();
    }
}
