package com.scaler.EcomProductService.controller;

import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductRequestDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;
import com.scaler.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("fakeStoreProductService")
    private ProductService productService;
    //here we will create 4 APIs for the CRUD operations
    @GetMapping("/products")
    public ResponseEntity getAllProducts()
    {
//        ProductResponseDTO p1 = new ProductResponseDTO();
//        p1.setId(1);
//        p1.setCategory("Electronics");
//        p1.setTitle("iPhone 15 Pro");
//        p1.setPrice(150000);
//        p1.setImage("www.google.com/images/iphone");
//        p1.setDescription("A new iPhone from Apple");
//
//        ProductResponseDTO p2 = new ProductResponseDTO();
//        p2.setId(2);
//        p2.setCategory("Electronics");
//        p2.setTitle("MacBook Pro");
//        p2.setPrice(250000);
//        p2.setImage("www.google.com/images/macbook");
//        p2.setDescription("A new laptop from Apple");
//
//        List<ProductResponseDTO> products = Arrays.asList(p1,p2);
//        return ResponseEntity.ok(products);
        ProductListResponseDTO productsList = productService.getAllProducts();
        return ResponseEntity.ok(productsList);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity getProductFromId(@PathVariable("id") int id)
    {
        ProductResponseDTO response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO)
    {
        ProductResponseDTO responseDTO = productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") int id)
    {
        boolean response = productService.deleteProduct(id);
        return ResponseEntity.ok(response);
    }
}
