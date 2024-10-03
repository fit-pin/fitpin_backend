package com.mzm.Fitpin.controller.app.fitstorage;

import com.mzm.Fitpin.entity.FitStorage;
import com.mzm.Fitpin.mapper.FitStorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/fit_comment")
public class FitCommentController {

    @Autowired
    private FitStorageMapper fitStorageMapper;

    // 코멘트 작성
    @PostMapping("/save_comment")
    public ResponseEntity<?> saveFitComment(@RequestParam("userEmail") String userEmail,
                                            @RequestParam("imageName") String imageName,
                                            @RequestParam("comment") String comment) {
        // 데이터베이스에서 해당 이미지 찾기
        FitStorage fitStorage = fitStorageMapper.findByUserEmailAndFitStorageImg(userEmail, imageName);

        if (fitStorage != null) {
            // 코멘트 저장
            fitStorage.setFitComment(comment);
            fitStorageMapper.update(fitStorage);
            return ResponseEntity.ok(Collections.singletonMap("message", "코멘트 저장 성공"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "이미지를 찾을 수 없습니다"));
        }
    }

    // 코멘트 수정
    @PostMapping("/update_comment")
    public ResponseEntity<?> updateFitComment(@RequestParam("userEmail") String userEmail,
                                              @RequestParam("imageName") String imageName,
                                              @RequestParam("comment") String comment) {
        // 데이터베이스에서 해당 이미지 찾기
        FitStorage fitStorage = fitStorageMapper.findByUserEmailAndFitStorageImg(userEmail, imageName);

        if (fitStorage != null) {
            // 기존 코멘트 수정
            fitStorage.setFitComment(comment);
            fitStorageMapper.update(fitStorage);
            return ResponseEntity.ok(Collections.singletonMap("message", "코멘트 수정 성공"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "이미지를 찾을 수 없습니다"));
        }
    }

    // 코멘트 삭제
    @DeleteMapping("/delete_comment")
    public ResponseEntity<?> deleteFitComment(@RequestParam("userEmail") String userEmail,
                                              @RequestParam("imageName") String imageName) {
        // 데이터베이스에서 해당 이미지 찾기
        FitStorage fitStorage = fitStorageMapper.findByUserEmailAndFitStorageImg(userEmail, imageName);

        if (fitStorage != null) {
            // 코멘트 삭제
            fitStorage.setFitComment(null);  // 코멘트를 null로 설정
            fitStorageMapper.update(fitStorage);
            return ResponseEntity.ok(Collections.singletonMap("message", "코멘트 삭제 성공"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "이미지를 찾을 수 없습니다"));
        }
    }
}
