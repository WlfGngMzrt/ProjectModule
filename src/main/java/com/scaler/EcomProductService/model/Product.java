package com.scaler.EcomProductService.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String title;
    @ManyToOne
    private Category category;
    private String description;
    private String image;
    @OneToOne
    private Price price;
    @ManyToMany
    private List<Order> order;


    /*
    Product  - Category : M : 1

     */

}
