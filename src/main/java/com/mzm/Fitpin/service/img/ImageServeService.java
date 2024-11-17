package com.mzm.Fitpin.service.img;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

@Service
public class ImageServeService {

    @Autowired
    ResourceLoader resourceLoader;

    private static final Logger logger = LoggerFactory.getLogger(ImageServeService.class);

    public ResponseEntity<?> serveImage(String imgUrl, String basePath) {
        try {
            String filePath = new File(imgUrl).getAbsolutePath();
            
            Resource resource = resourceLoader.getResource("file:"+filePath);

            if (!resource.exists() || !resource.isReadable()) {
                logger.error("File not found or not readable: " + imgUrl);
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Collections.singletonMap("message", "파일을 찾을 수 없습니다."));
            }

            String contentType = Files.probeContentType(Path.of(resource.getURI()));
            if (contentType == null) {
                contentType = "application/octet-stream";
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (IOException e) {
            logger.error("Error reading file: " + imgUrl, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("message", "파일을 읽는 중 오류가 발생했습니다."));
        }
    }
}
