package com.mzm.Fitpin.controller.app;

import com.mzm.Fitpin.dto.ItemBottomInfoDTO;
import com.mzm.Fitpin.dto.ItemInfoDTO;
import com.mzm.Fitpin.dto.ItemTopInfoDTO;
import com.mzm.Fitpin.exception.CustomException;
import com.mzm.Fitpin.mapper.ItemInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/item-info")
public class ItemInfoController {

    @Autowired
    private ItemInfoMapper itemInfoMapper;

    @GetMapping("/{itemKey}")
    public ResponseEntity<?> getItemInfo(@PathVariable int itemKey) {
        try {
            ItemInfoDTO itemInfo = itemInfoMapper.findItemByKey(itemKey);
            if (itemInfo == null) {
                throw new CustomException("해당 키의 상품을 찾을 수 없습니다.");
            }

            itemInfo.setItemImgUrls(itemInfoMapper.findItemImages(itemKey));

            if (itemInfo.getItemType().equalsIgnoreCase("상의")) {
                ItemTopInfoDTO topInfo = itemInfoMapper.findTopInfoByKey(itemKey);
                itemInfo.setItemTopInfo(topInfo);
            } else if (itemInfo.getItemType().equalsIgnoreCase("하의")) {
                ItemBottomInfoDTO bottomInfo = itemInfoMapper.findBottomInfoByKey(itemKey);
                itemInfo.setItemBottomInfo(bottomInfo);
            } else {
                throw new CustomException("상품 종류를 확인할 수 없습니다.");
            }

            return ResponseEntity.ok(itemInfo);
        } catch (CustomException e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "상품 정보 조회 중 오류가 발생했습니다."));
        }
    }
}
