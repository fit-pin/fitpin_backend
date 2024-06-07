package com.mzm.Fitpin.service;

import com.mzm.Fitpin.entity.Item;
import com.mzm.Fitpin.mapper.ItemSearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemSearchService {

    @Autowired
    private ItemSearchMapper itemSearchMapper;

    public List<Item> searchItems(String query) {
        return itemSearchMapper.searchItems(query);
    }
}
