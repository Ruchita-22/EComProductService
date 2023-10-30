package com.scaler.EComProductService.service;

import com.scaler.EComProductService.dto.ProductListResponseDTO;
import com.scaler.EComProductService.dto.ProductRequestDTO;
import com.scaler.EComProductService.dto.ProductResponseDTO;
import com.scaler.EComProductService.exception.ProductNotFoundException;
import com.scaler.EComProductService.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductById(int id) throws ProductNotFoundException;
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    boolean deleteProduct(int id);
    ProductResponseDTO updateProduct(int id, Product updatedProduct);
}
