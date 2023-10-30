package com.scaler.EComProductService.service;

import com.scaler.EComProductService.client.FakeStoreAPIClient;
import com.scaler.EComProductService.dto.*;
import com.scaler.EComProductService.exception.ProductNotFoundException;
import com.scaler.EComProductService.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.scaler.EComProductService.mapper.ProductMapper.productRequestToFakeStoreProductRequest;
import static com.scaler.EComProductService.mapper.ProductMapper.fakeStoreProductResponseToProductResponse;
import static com.scaler.EComProductService.util.ProductUtils.isNull;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService{
    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductServiceImpl(FakeStoreAPIClient fakeStoreAPIClient) {
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    /**
     * we should put autowire for contructor injection but with new version it is not needed
     * it will be done automatically only for constructor injection
     * //@param restTemplateBuilder
     * //@param fakeStoreAPIClient
     */

    @Override
    public ProductListResponseDTO getAllProducts() {

        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOList = fakeStoreAPIClient.getAllProducts();
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        for(FakeStoreProductResponseDTO fakeStoreProductResponseDTO : fakeStoreProductResponseDTOList){
            productListResponseDTO.getProducts().add(fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO));
        }
        return productListResponseDTO;
    }
    @Override
    public ProductResponseDTO getProductById(int id) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.getProductById(id);
        if(isNull(fakeStoreProductResponseDTO)){
            throw new ProductNotFoundException("Product not found with id:"+ id);
        }
        else
            return fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = productRequestToFakeStoreProductRequest(productRequestDTO);
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDTO);
        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }


    @Override
    public boolean deleteProduct(int id) {
        fakeStoreAPIClient.deleteProduct(id);
        return true;
    }

    @Override
    public ProductResponseDTO updateProduct(int id, Product updatedProduct) {
        return null;
    }
}
