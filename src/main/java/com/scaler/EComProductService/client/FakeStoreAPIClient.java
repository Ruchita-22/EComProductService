package com.scaler.EComProductService.client;

import com.scaler.EComProductService.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper on FakeStoreProduct api
 */
@Component
public class FakeStoreAPIClient {
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.url}")
    private String fakeStoreAPIURL;
    @Value("${fakestore.api.path.product}")
    private String fakeStoreAPIPathProduct;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        String createProductUrl  = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductResponseDTO> productResponse =
                restTemplate.postForEntity(createProductUrl, fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }
    public FakeStoreProductResponseDTO getProductById(int id) {
        String getProductByUrlId = fakeStoreAPIURL + fakeStoreAPIPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOResponseEntity =
                restTemplate.getForEntity(getProductByUrlId, FakeStoreProductResponseDTO.class);
        return fakeStoreProductResponseDTOResponseEntity.getBody();
    }
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        String getAllProducts = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductResponseDTO[]> fakeStoreProductResponseDTOArray =
                restTemplate.getForEntity(getAllProducts, FakeStoreProductResponseDTO[].class);
        ProductListResponseDTO responseDTO = new ProductListResponseDTO();
        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOList = new ArrayList<>();
        for (FakeStoreProductResponseDTO fakeStoreProductResponseDTO : fakeStoreProductResponseDTOArray.getBody()) {
            fakeStoreProductResponseDTOList.add(fakeStoreProductResponseDTO);
        }
        return fakeStoreProductResponseDTOList;
    }
    public boolean deleteProduct(int id) {
        String productDeleteURL = fakeStoreAPIURL + fakeStoreAPIPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();

        restTemplate.delete(productDeleteURL);
        return true;
    }
}
