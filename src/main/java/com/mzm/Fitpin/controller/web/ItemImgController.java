package com.mzm.Fitpin.controller.web;

import com.mzm.Fitpin.entity.ItemImg;
import com.mzm.Fitpin.mapper.ItemImgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

@RestController
@RequestMapping("/api/itemImages")
public class ItemImgController {

    @Autowired
    private ItemImgMapper itemImgMapper;

    @Value("${item-image-file.ItemImage-Upload-dir}")
    private String uploadDir;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("itemKey") int itemKey,
                                         @RequestParam("image") MultipartFile image) {
        try {
            // 절대 경로를 설정 (서버에 저장될 디렉토리)
            String absoluteUploadDir = new File(uploadDir).getAbsolutePath();
            File uploadDirFile = new File(absoluteUploadDir);

            // 업로드 디렉토리가 없으면 생성
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs();
            }

            // 이미지 파일을 서버에 저장 (절대 경로 사용)
            String imagePath = absoluteUploadDir + "/" + image.getOriginalFilename();
            File dest = new File(imagePath);
            image.transferTo(dest);

            // DB에는 파일명만 저장
            ItemImg itemImg = new ItemImg();
            itemImg.setItemKey(itemKey);
            // 경로 대신 파일명만 저장
            itemImg.setItemImgName(image.getOriginalFilename());
            itemImgMapper.insert(itemImg);

            return ResponseEntity.ok(Collections.singletonMap("message", "이미지 업로드 성공: " + image.getOriginalFilename()));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("message", "이미지 업로드 실패: " + e.getMessage()));
        }
    }
}
