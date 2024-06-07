package com.mzm.Fitpin.service;

import com.mzm.Fitpin.entity.ItemBottomSize;
import com.mzm.Fitpin.mapper.ItemBottomSizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBottomSizeService {
    @Autowired
    private ItemBottomSizeMapper itemBottomSizeMapper;

    public List<ItemBottomSize> getItemBottomSizesByItemKey(Integer itemKey) {
        return itemBottomSizeMapper.getItemBottomSizesByItemKey(itemKey);
    }
}
