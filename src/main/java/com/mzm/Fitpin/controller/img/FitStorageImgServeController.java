package com.mzm.Fitpin.controller.img;

import com.mzm.Fitpin.service.img.ImageServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/img/imgserve/fitstorageimg")
public class FitStorageImgServeController {

    @Autowired
    private ImageServeService imageServeService;

    @Value("${item-image-file.ItemImage-Upload-dir}")
    private String basePath;

    @GetMapping("/{imageName}")
    public ResponseEntity<?> getImage(@PathVariable String imageName) {
        // 파일 경로 전달
        String imgUrl = basePath + "/" + imageName;
        return imageServeService.serveImage(imgUrl, basePath);
    }
}
