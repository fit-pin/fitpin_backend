package com.mzm.Fitpin.controller.app;

import com.mzm.Fitpin.dto.PitBottomDTO;
import com.mzm.Fitpin.dto.PitTopDTO;
import com.mzm.Fitpin.mapper.PitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/pit")
public class PitController {

    @Autowired
    private PitMapper pitMapper;

    @GetMapping("/get/{cartKey}")
    public ResponseEntity<?> getPitDetails(@PathVariable int cartKey) {
        try {
            PitTopDTO pitTop = pitMapper.findPitTopByCartKey(cartKey);
            PitBottomDTO pitBottom = pitMapper.findPitBottomByCartKey(cartKey);

            if (pitTop != null) {
                return ResponseEntity.ok(pitTop);
            } else if (pitBottom != null) {
                return ResponseEntity.ok(pitBottom);
            } else {
                return ResponseEntity.status(404).body(Collections.singletonMap("message", "수선 정보를 찾을 수 없습니다."));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "수선 정보 조회 중 오류가 발생했습니다."));
        }
    }
}
