package com.mzm.Fitpin.service;

import com.mzm.Fitpin.entity.PitBottom;
import com.mzm.Fitpin.entity.PitTop;
import com.mzm.Fitpin.mapper.PitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PitService {

    @Autowired
    private PitMapper pitMapper;

    public void addPitTop(PitTop pitTop) {
        pitMapper.insertPitTop(pitTop);
    }

    public void addPitBottom(PitBottom pitBottom) {
        pitMapper.insertPitBottom(pitBottom);
    }
}
