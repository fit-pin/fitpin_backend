package com.mzm.Fitpin.entity;

import lombok.Data;

@Data
public class UserForm {
    private String userEmail;
    private String fileName;
    private Float armSize;
    private Float shoulderSize;
    private Float bodySize;
    private Float legSize;
}
