package com.mzm.Fitpin.entity.login_register;

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
