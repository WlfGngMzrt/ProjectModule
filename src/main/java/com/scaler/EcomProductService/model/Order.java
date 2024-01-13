package com.scaler.EcomProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Entity(name = "ECOM_ORDER")
@Data
public class Order extends BaseModel{
    @ManyToMany
    private List<Product> productList;
}
