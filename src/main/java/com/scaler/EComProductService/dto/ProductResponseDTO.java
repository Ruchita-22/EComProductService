package com.scaler.EComProductService.dto;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private  int id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
