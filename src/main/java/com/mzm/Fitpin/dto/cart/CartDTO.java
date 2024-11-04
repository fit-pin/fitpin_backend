package com.mzm.Fitpin.dto.cart;

import com.mzm.Fitpin.dto.PitBottomDTO;
import com.mzm.Fitpin.dto.PitTopDTO;
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
    private boolean pitStatus;
    private int qty;

    private PitBottomDTO pitBottomInfo;
    private PitTopDTO pitTopInfo;
}
