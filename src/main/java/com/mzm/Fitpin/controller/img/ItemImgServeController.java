package com.mzm.Fitpin.controller.img;

import com.mzm.Fitpin.service.img.ImageServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/img/imgserve/itemimg")
public class ItemImgServeController {

    @Autowired
    private ImageServeService imageServeService;

    @GetMapping("/{imageName}")
    public ResponseEntity<?> getImage(@PathVariable String imageName) {
        // 기본 경로 설정 (이미지 파일이 있는 디렉토리)
        String basePath = "/home/ubuntu/home/fitpin_backend/home/itemImg";
        // 파일 전체 경로를 전달
        String imgUrl = basePath + "/" + imageName;
        return imageServeService.serveImage(imgUrl, basePath);
    }
}
