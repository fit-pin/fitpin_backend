package com.mzm.Fitpin.service;

import com.mzm.Fitpin.entity.Item;
import com.mzm.Fitpin.mapper.ItemDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemDetailsService {
    @Autowired
    private ItemDetailsMapper itemDetailsMapper;

    public Item getItemDetailsById(Integer itemKey) {
        return itemDetailsMapper.getItemDetailsById(itemKey);
    }
}
