package com.mzm.Fitpin.controller.app;

import com.mzm.Fitpin.entity.FitStorage;
import com.mzm.Fitpin.mapper.FitStorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/fitStorageImages")
public class FitStorageImageController {

    private static final Logger logger = LoggerFactory.getLogger(FitStorageImageController.class);

    @Autowired
    private FitStorageMapper fitStorageMapper;

    @Value("${fit-storage-file.FitStorage-Upload-dir}")
    private String uploadDir;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("userEmail") String userEmail,
                                         @RequestParam("image") MultipartFile image) {
        try {
            // 업로드 디렉토리가 없으면 생성
            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs();
            }

            // 이미지 파일을 서버에 저장
            String imagePath = uploadDir + "/" + image.getOriginalFilename();
            File dest = new File(imagePath);
            image.transferTo(dest);

            // 이미지 경로를 DB에 저장
            FitStorage fitStorage = new FitStorage();
            fitStorage.setUserEmail(userEmail);
            fitStorage.setFitStorageImgURL(imagePath);
            fitStorageMapper.insert(fitStorage);

            return ResponseEntity.ok(Collections.singletonMap("message", "이미지 업로드 성공: " + imagePath));
        } catch (IOException e) {
            logger.error("Image upload failed: " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("message", "이미지 업로드 실패: " + e.getMessage()));
        }
    }

    @GetMapping("/user/{userEmail}")
    public ResponseEntity<List<FitStorage>> getImagesByUserEmail(@PathVariable String userEmail) {
        List<FitStorage> images = fitStorageMapper.findByUserEmail(userEmail);
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteImage(@RequestParam("fitStorageImgURL") String fitStorageImgURL) {
        try {
            // 파일 삭제
            File file = new File(fitStorageImgURL);
            if (file.exists()) {
                if (file.delete()) {
                    // DB에서 이미지 경로 삭제
                    fitStorageMapper.deleteByFitStorageImgURL(fitStorageImgURL);
                    return ResponseEntity.ok(Collections.singletonMap("message", "이미지 삭제 성공: " + fitStorageImgURL));
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body(Collections.singletonMap("message", "이미지 삭제 실패: " + fitStorageImgURL));
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Collections.singletonMap("message", "이미지를 찾을 수 없습니다: " + fitStorageImgURL));
            }
        } catch (Exception e) {
            logger.error("Image delete failed: " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("message", "이미지 삭제 실패: " + e.getMessage()));
        }
    }
}