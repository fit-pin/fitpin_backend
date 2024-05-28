package com.mzm.Fitpin.service;

import com.mzm.Fitpin.entity.Item;
import com.mzm.Fitpin.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemMapper itemMapper;

    public void addItem(Item item) {
        itemMapper.insertItem(item);
    }
}
