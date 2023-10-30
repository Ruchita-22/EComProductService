package com.scaler.EComProductService.controller;

import com.scaler.EComProductService.dto.ProductListResponseDTO;
import com.scaler.EComProductService.dto.ProductRequestDTO;
import com.scaler.EComProductService.dto.ProductResponseDTO;
import com.scaler.EComProductService.exception.ProductNotFoundException;
import com.scaler.EComProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(@Qualifier(value = "fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    /*
     * Field Injection
    @Autowired
    @Qualifier(value = "fakeStoreProductService")
    private ProductService productService;
     */

    @GetMapping("/products")
    public ResponseEntity getAllProduct(){


       /* ProductReponseDTO p1 = new ProductReponseDTO();
        p1.setId(1);
        p1.setTitle("Iphone 15 pro");
        p1.setPrice(150000);
        p1.setImage("https://www.google.com/images/iphone");
        p1.setDescription("Kafi Mehnga Phone");
        p1.setCategory("Electronics");

        ProductReponseDTO p2 = new ProductReponseDTO();
        p2.setId(1);
        p2.setTitle("Macbook pro");
        p2.setPrice(250000);
        p2.setImage("https://www.google.com/images/macbook");
        p2.setDescription("Kafi Mehnga Laptop");
        p2.setCategory("Electronics");
        List<ProductReponseDTO> products = Arrays.asList(p1,p2);
        return ResponseEntity.ok(products);
        */

        ProductListResponseDTO response = productService.getAllProducts();
        return ResponseEntity.ok(response);

    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id) throws ProductNotFoundException {
        ProductResponseDTO response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO response = productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProductById(@PathVariable("id") int id){
        boolean response = productService.deleteProduct(id);
        return ResponseEntity.ok(response);
    }
}
