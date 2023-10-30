package com.scaler.EComProductService.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ProductListResponseDTO {
    private List<ProductResponseDTO> products;
    public ProductListResponseDTO(){
        this.products = new ArrayList<>();
    }
}
