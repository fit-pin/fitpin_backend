package com.mzm.Fitpin.dto.cart;

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
    private int pit;
    private int qty; // New field for item quantity
}
