package com.mzm.Fitpin.controller.app;

import com.mzm.Fitpin.dto.ItemWithImagesDTO;
import com.mzm.Fitpin.exception.CustomException;
import com.mzm.Fitpin.mapper.ItemWithImagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemListController {

    @Autowired
    private ItemWithImagesMapper itemWithImagesMapper;

    @GetMapping("/list/{itemType}")
    public ResponseEntity<?> getItemsByType(@PathVariable String itemType) {
        try {
            List<ItemWithImagesDTO> itemsWithImages = itemWithImagesMapper.findItemsWithImagesByType(itemType);
            if (itemsWithImages == null || itemsWithImages.isEmpty()) {
                throw new CustomException("해당 종류의 상품을 찾을 수 없습니다.");
            }
            return ResponseEntity.ok(itemsWithImages);
        } catch (CustomException e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "상품 조회 중 오류가 발생했습니다."));
        }
    }
}
