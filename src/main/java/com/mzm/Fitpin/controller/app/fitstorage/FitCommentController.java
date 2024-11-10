package com.mzm.Fitpin.controller.app.fitstorage;

import com.mzm.Fitpin.dto.FitStorageDTO;
import com.mzm.Fitpin.entity.FitStorage;
import com.mzm.Fitpin.mapper.fitStorage.FitStorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
//todo: API 문서 수정
@RestController
@RequestMapping("/api/fit_comment")
public class FitCommentController {

    @Autowired
    private FitStorageMapper fitStorageMapper;

    // 코멘트 전체 리턴
    @GetMapping("/get_fitcomment")
    public ResponseEntity<?> getFitComment() {
        // 모든 코멘트를 조회
        List<FitStorage> fitComments = fitStorageMapper.findAllFitComments();

        // 조회한 결과를 DTO로 변환
        List<FitStorageDTO> fitStorageDTOList = fitComments.stream()
                .map(fitStorage -> {
                    FitStorageDTO dto = new FitStorageDTO();
                    dto.setFitStorageKey(fitStorage.getFitStorageKey());
                    dto.setUserEmail(fitStorage.getUserEmail());
                    dto.setFitStorageImg(fitStorage.getFitStorageImg());
                    dto.setFitComment(fitStorage.getFitComment());
                    dto.setItemName(fitStorage.getItemName());
                    dto.setItemType(fitStorage.getItemType());
                    dto.setItemBrand(fitStorage.getItemBrand());
                    dto.setItemSize(fitStorage.getItemSize());
                    dto.setOption(fitStorage.getOption());
                    dto.setDeleteStatus(fitStorage.isDeleteStatus());
                    dto.setCommentDate(fitStorage.getCommentDate());
                    return dto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(fitStorageDTOList);
    }

    // 특정 코멘트 조회
    @GetMapping("/get_fitcomment/{fitStorageKey}")
    public ResponseEntity<?> getFitCommentByKey(@PathVariable("fitStorageKey") int fitStorageKey) {
        // fitcommentKey를 사용하여 데이터베이스에서 해당 요소 조회
        FitStorageDTO fitStorageDTO = fitStorageMapper.findByFitCommentKey(fitStorageKey);

        if (fitStorageDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "해당 키에 대한 데이터를 찾을 수 없습니다."));
        } else if (fitStorageDTO.isDeleteStatus()) {
            return ResponseEntity.status(404)
                    .body(Collections.singletonMap("message", "삭제된 코멘트 입니다"));
        } else {
            return ResponseEntity.ok(fitStorageDTO);
        }
    }



    // 코멘트 작성
    @PostMapping("/save_comment")
    public ResponseEntity<?> saveFitComment(@RequestBody FitStorageDTO fitStorageDTO) {

        // 파라미터 추출
        String userEmail = fitStorageDTO.getUserEmail();
        String imageName = fitStorageDTO.getFitStorageImg();
        String comment = fitStorageDTO.getFitComment();
        String itemName = fitStorageDTO.getItemName();  // 추가된 필드
        String itemType = fitStorageDTO.getItemType();
        String itemBrand = fitStorageDTO.getItemBrand();
        String itemSize = fitStorageDTO.getItemSize();
        String option = fitStorageDTO.getOption();

        // 데이터베이스에서 해당 이미지 찾기
        FitStorage fitStorage = fitStorageMapper.findByUserEmailAndFitStorageImg(userEmail, imageName);

        if (fitStorage != null) {
            // 기존 이미지에 코멘트와 추가 정보를 저장
            fitStorage.setFitComment(comment);
            fitStorage.setItemName(itemName);  // 추가된 필드 설정
            fitStorage.setItemType(itemType);
            fitStorage.setItemBrand(itemBrand);
            fitStorage.setItemSize(itemSize);
            fitStorage.setOption(option);
            fitStorageMapper.update(fitStorage);

            return ResponseEntity.ok(Collections.singletonMap("message", "코멘트 저장 및 정보 업데이트 성공"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "핏코멘트를 찾을 수 없습니다"));
        }
    }

    // 코멘트 수정
    @PostMapping("/update_comment")
    public ResponseEntity<?> updateFitComment(@RequestBody FitStorageDTO fitStorageDTO) {

        // 파라미터 추출
        String userEmail = fitStorageDTO.getUserEmail();
        String imageName = fitStorageDTO.getFitStorageImg();
        String comment = fitStorageDTO.getFitComment();
        String itemName = fitStorageDTO.getItemName();  // 추가된 필드
        String itemType = fitStorageDTO.getItemType();
        String itemBrand = fitStorageDTO.getItemBrand();
        String itemSize = fitStorageDTO.getItemSize();
        String option = fitStorageDTO.getOption();

        // 데이터베이스에서 해당 핏 코멘트 찾기
        FitStorage fitStorage = fitStorageMapper.findByUserEmailAndFitStorageImg(userEmail, imageName);

        if (fitStorage != null) {
            // 기존 코멘트 및 정보를 수정
            fitStorage.setFitComment(comment);
            fitStorage.setItemName(itemName);  // 추가된 필드 설정
            fitStorage.setItemType(itemType);
            fitStorage.setItemBrand(itemBrand);
            fitStorage.setItemSize(itemSize);
            fitStorage.setOption(option);
            fitStorageMapper.update(fitStorage);

            return ResponseEntity.ok(Collections.singletonMap("message", "코멘트 및 정보 수정 성공"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "핏코멘트를 찾을 수 없습니다"));
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
            // deleteStatus만 true로 설정
            fitStorageMapper.update_DeleteStatus(userEmail, imageName);

            return ResponseEntity.ok(Collections.singletonMap("message", "코멘트 및 정보 삭제 성공"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "핏코멘트를 찾을 수 없습니다"));
        }
    }


    @DeleteMapping("/delete_comment_real/{fitStorageKey}")
    public ResponseEntity<?> deleteByFitStorageKey(@PathVariable("fitStorageKey") int fitStorageKey) {

        // fitcommentKey를 사용하여 데이터베이스에서 삭제
        fitStorageMapper.deleteByFitStorageKey(fitStorageKey);
        return ResponseEntity.ok(Collections.singletonMap("message", "DB상에서 진짜로 삭제 성공"));
    }
}
