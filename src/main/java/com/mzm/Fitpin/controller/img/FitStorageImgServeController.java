package com.mzm.Fitpin.controller.img;

import com.mzm.Fitpin.service.img.ImageServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/img/imgserve/fitstorageimg")
public class FitStorageImgServeController {

    @Autowired
    private ImageServeService imageServeService;

    @GetMapping
    public ResponseEntity<?> getImage(@RequestParam("imgUrl") String imgUrl) {
        String basePath = "/home/ubuntu/home/fitpin_backend/home/fitStorageImg";
        return imageServeService.serveImage(imgUrl, basePath);
    }
}
