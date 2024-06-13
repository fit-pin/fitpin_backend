package com.mzm.Fitpin.controller;

import com.mzm.Fitpin.entity.PitBottom;
import com.mzm.Fitpin.entity.PitTop;
import com.mzm.Fitpin.service.PitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//수선 내용을 저장하는 api입니다. /top 엔드포인트는 상의 엔드포인트, /bottom 엔드포인트는 하의에 대한 엔드포인트입니다.
@RestController
@RequestMapping("/api/pit")
public class PitController {

    @Autowired
    private PitService pitService;

    @PostMapping("/top")
    public ResponseEntity<Void> createPitTop(@RequestBody PitTop pitTop) {
        pitService.addPitTop(pitTop);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/bottom")
    public ResponseEntity<Void> createPitBottom(@RequestBody PitBottom pitBottom) {
        pitService.addPitBottom(pitBottom);
        return ResponseEntity.ok().build();
    }
}
