package com.scaler.EcomProductService.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String title;
    private double price;
    @ManyToOne
    private Category category;
    private String description;
    private String image;


    /*
    Product  - Category : M : 1

     */

}
