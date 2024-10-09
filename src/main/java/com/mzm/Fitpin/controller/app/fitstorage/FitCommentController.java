package com.mzm.Fitpin.controller.app.fitstorage;

import com.mzm.Fitpin.dto.FitStorageDTO;
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
    public ResponseEntity<?> saveFitComment(@RequestBody FitStorageDTO fitStorageDTO) {

        // 파라미터 추출
        String userEmail = fitStorageDTO.getUserEmail();
        String imageName = fitStorageDTO.getFitStorageImg();
        String comment = fitStorageDTO.getFitComment();
        String itemType = fitStorageDTO.getItemType();
        String itemBrand = fitStorageDTO.getItemBrand();
        String itemSize = fitStorageDTO.getItemSize();
        String option = fitStorageDTO.getOption();

        // 데이터베이스에서 해당 이미지 찾기
        FitStorage fitStorage = fitStorageMapper.findByUserEmailAndFitStorageImg(userEmail, imageName);

        if (fitStorage != null) {
            // 기존 이미지에 코멘트와 추가 정보를 저장
            fitStorage.setFitComment(comment);
            fitStorage.setItemType(itemType);
            fitStorage.setItemBrand(itemBrand);
            fitStorage.setItemSize(itemSize);
            fitStorage.setOption(option);
            fitStorageMapper.update(fitStorage);

            return ResponseEntity.ok(Collections.singletonMap("message", "코멘트 저장 및 정보 업데이트 성공"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "이미지를 찾을 수 없습니다"));
        }
    }

    // 코멘트 수정
    @PostMapping("/update_comment")
    public ResponseEntity<?> updateFitComment(@RequestBody FitStorageDTO fitStorageDTO) {

        // 파라미터 추출
        String userEmail = fitStorageDTO.getUserEmail();
        String imageName = fitStorageDTO.getFitStorageImg();
        String comment = fitStorageDTO.getFitComment();
        String itemType = fitStorageDTO.getItemType();
        String itemBrand = fitStorageDTO.getItemBrand();
        String itemSize = fitStorageDTO.getItemSize();
        String option = fitStorageDTO.getOption();

        // 데이터베이스에서 해당 이미지 찾기
        FitStorage fitStorage = fitStorageMapper.findByUserEmailAndFitStorageImg(userEmail, imageName);

        if (fitStorage != null) {
            // 기존 코멘트 및 정보를 수정
            fitStorage.setFitComment(comment);
            fitStorage.setItemType(itemType);
            fitStorage.setItemBrand(itemBrand);
            fitStorage.setItemSize(itemSize);
            fitStorage.setOption(option);
            fitStorageMapper.update(fitStorage);

            return ResponseEntity.ok(Collections.singletonMap("message", "코멘트 및 정보 수정 성공"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "이미지를 찾을 수 없습니다"));
        }
    }

    // 코멘트 삭제
    @DeleteMapping("/delete_comment")
    public ResponseEntity<?> deleteFitComment(@RequestBody FitStorageDTO fitStorageDTO) {

        // 파라미터 추출
        String userEmail = fitStorageDTO.getUserEmail();
        String imageName = fitStorageDTO.getFitStorageImg();

        // 데이터베이스에서 해당 이미지 찾기
        FitStorage fitStorage = fitStorageMapper.findByUserEmailAndFitStorageImg(userEmail, imageName);

        if (fitStorage != null) {
            // 코멘트 및 정보 삭제
            fitStorage.setFitComment(null);
            fitStorage.setItemType(null);
            fitStorage.setItemBrand(null);
            fitStorage.setItemSize(null);
            fitStorage.setOption(null);
            fitStorageMapper.update(fitStorage);

            return ResponseEntity.ok(Collections.singletonMap("message", "코멘트 및 정보 삭제 성공"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "이미지를 찾을 수 없습니다"));
        }
    }
}
