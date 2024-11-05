package com.mzm.Fitpin.controller.app;

import com.mzm.Fitpin.dto.pit.PitItemCartDTO;
import com.mzm.Fitpin.mapper.pit.PitItemCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/pit")
public class PitController {

    @Autowired
    private PitItemCartMapper pitItemCartMapper;

    @GetMapping("/get/{cartKey}") //TODO: 이거안됨ㅋ 일단나중에
    public ResponseEntity<?> getPitDetails(@PathVariable int cartKey) {
        try {
            PitItemCartDTO pitItemCart = pitItemCartMapper.findPitItemByCartKey(cartKey);
            if (pitItemCart != null) {
                return ResponseEntity.ok(pitItemCart);
            } else {
                return ResponseEntity.status(404).body(Collections.singletonMap("message", "수선 정보를 찾을 수 없습니다."));
            }
        } catch (Exception e) {
            e.getStackTrace();
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "수선 정보 조회 중 오류가 발생했습니다."));
        }
    }
}
