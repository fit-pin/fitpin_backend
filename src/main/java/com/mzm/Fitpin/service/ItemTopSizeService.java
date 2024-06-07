package com.mzm.Fitpin.service;

import com.mzm.Fitpin.entity.ItemTopSize;
import com.mzm.Fitpin.mapper.ItemTopSizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemTopSizeService {
    @Autowired
    private ItemTopSizeMapper itemTopSizeMapper;

    public List<ItemTopSize> getItemTopSizesByItemKey(Integer itemKey) {
        return itemTopSizeMapper.getItemTopSizesByItemKey(itemKey);
    }
}
