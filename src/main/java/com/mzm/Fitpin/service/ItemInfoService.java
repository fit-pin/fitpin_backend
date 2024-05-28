package com.mzm.Fitpin.service;

import com.mzm.Fitpin.entity.ItemInfo;
import com.mzm.Fitpin.mapper.ItemInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemInfoService {
    @Autowired
    private ItemInfoMapper itemInfoMapper;

    public ItemInfo getItemInfoById(Integer itemKey) {
        return itemInfoMapper.getItemInfoById(itemKey);
    }
}
