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
//사용법 작성 해야함
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
            ItemImg itemImg = new ItemImg();
            itemImg.setItemKey(itemKey);
            itemImg.setItemImgURL(imagePath);
            itemImgMapper.insert(itemImg);

            return ResponseEntity.ok(Collections.singletonMap("message", "이미지 업로드 성공: " + imagePath));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("message", "이미지 업로드 실패: " + e.getMessage()));
        }
    }
}
