package com.mzm.Fitpin.dto.login_register;

import lombok.Data;

@Data
public class UserBodyInfoDTO {
    private String userEmail;
    private Integer userHeight;
    private Integer userWeight;
    private Float armSize;
    private Float shoulderSize;
    private Float bodySize;
    private Float legSize;
}
