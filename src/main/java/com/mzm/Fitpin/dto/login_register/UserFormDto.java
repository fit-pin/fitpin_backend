package com.mzm.Fitpin.dto.login_register;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class UserFormDto {
    private String userEmail;
    private String fileName;
    private Float armSize;
    private Float shoulderSize;
    private Float bodySize;
    private Float legSize;

    @JsonProperty("result")
    private void unpackNested(Map<String, Object> result) {
        this.armSize = ((Number) result.get("armSize")).floatValue();
        this.shoulderSize = ((Number) result.get("shoulderSize")).floatValue();
        this.bodySize = ((Number) result.get("bodySize")).floatValue();
        this.legSize = ((Number) result.get("legSize")).floatValue();
    }
}
