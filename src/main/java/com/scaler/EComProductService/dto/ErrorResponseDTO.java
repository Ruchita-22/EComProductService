package com.scaler.EComProductService.dto;

import lombok.Data;


@Data
public class ErrorResponseDTO {
    private String message;
    private int messageCode;
}
