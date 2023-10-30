package com.scaler.EComProductService.dto;

import lombok.Data;

@Data
public class ProductRequestDTO {
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
