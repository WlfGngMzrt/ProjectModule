package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.client.FakeStoreAPIClient;
import com.scaler.EcomProductService.dto.*;
import com.scaler.EcomProductService.exception.ProductNotFoundException;
import com.scaler.EcomProductService.mapper.ProductMapper;
import com.scaler.EcomProductService.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.scaler.EcomProductService.utils.ProductUtils.*;

import java.util.ArrayList;
import java.util.List;

import static com.scaler.EcomProductService.utils.ProductUtils.isNull;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreAPIClient fakeStoreAPIClient;


    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOList = fakeStoreAPIClient.getAllProducts();
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        for(FakeStoreProductResponseDTO fakeStoreProductResponseDTO : fakeStoreProductResponseDTOList)
        {
            productListResponseDTO.getProducts().add(ProductMapper.fakeProductResponseToProductResponse(fakeStoreProductResponseDTO));
        }
        return productListResponseDTO;
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.getProductById(id);
        if (isNull(fakeStoreProductResponseDTO))
        {
            throw new ProductNotFoundException("Product not found with the id " + id);
        }
        return ProductMapper.fakeProductResponseToProductResponse(fakeStoreProductResponseDTO);

    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {

        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = ProductMapper.productRequestToFakeStoreProductRequest(productRequestDTO);
        FakeStoreProductResponseDTO fakeStoreProductDTO = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDTO);
        return ProductMapper.fakeProductResponseToProductResponse(fakeStoreProductDTO);

    }

    @Override
    public boolean deleteProduct(int id) {
        fakeStoreAPIClient.deleteProduct(id);
        return true;
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return null;
    }
}
