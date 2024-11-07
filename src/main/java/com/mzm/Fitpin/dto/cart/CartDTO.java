package com.mzm.Fitpin.dto.cart;

import com.mzm.Fitpin.dto.pit.PitItemCartDTO;
import lombok.Data;

@Data
public class CartDTO {
    private int cartKey;
    private int itemKey;
    private String userEmail;
    private String itemImgName;
    private String itemName;
    private String itemSize;
    private String itemType;
    private int itemPrice;
    private Integer pitPrice;  // 새로 추가된 필드
    private boolean pitStatus;
    private int qty;

    private PitItemCartDTO pitItemCart;
}
