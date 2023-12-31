package com.scaler.EcomProductService.client;

import com.scaler.EcomProductService.dto.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/*
 * Wrapper on the FakeStoreImplementation


 */
@Component
public class FakeStoreAPIClient {

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO)
    {
        String createProductURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse =
                restTemplate.postForEntity(createProductURL,fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public FakeStoreProductResponseDTO getProductById(int id)
    {

        String getProductByUrlId = "https://fakestoreapi.com/products" + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse =
                restTemplate.getForEntity(getProductByUrlId,FakeStoreProductResponseDTO.class);
        return productResponse.getBody();

    }

    public List<FakeStoreProductResponseDTO> getAllProducts()
    {
        String getAllProductsURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseArray =
                restTemplate.getForEntity(getAllProductsURL,FakeStoreProductResponseDTO[].class);
        return List.of(productResponseArray.getBody());
    }

    public void deleteProduct(int id)
    {
        String productURL = "https://fakestoreapi.com/products/" + id ;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(productURL);

    }
}
