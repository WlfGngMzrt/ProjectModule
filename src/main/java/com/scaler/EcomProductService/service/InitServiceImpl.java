package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.model.Category;
import com.scaler.EcomProductService.model.Order;
import com.scaler.EcomProductService.model.Price;
import com.scaler.EcomProductService.model.Product;
import com.scaler.EcomProductService.repository.CategoryRepository;
import com.scaler.EcomProductService.repository.OrderRepository;
import com.scaler.EcomProductService.repository.PriceRepository;
import com.scaler.EcomProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitServiceImpl implements InitService{


    private ProductRepository productRepository;
    private PriceRepository priceRepository;
    private OrderRepository orderRepository;
    private CategoryRepository categoryRepository;

    public InitServiceImpl(ProductRepository productRepository, PriceRepository priceRepository, OrderRepository orderRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }



    @Override
    public void initialize() {

        Category electronics = new Category();
        electronics.setCategoryName("Electronics");

        // save -> used for both insert and update
        //upsert -> insert + update
        Category savedCategory = categoryRepository.save(electronics);

        Price priceIphone = new Price();
        priceIphone.setCurrency("INR");
        priceIphone.setAmount(100000);
        priceIphone.setDiscount(0);

        Price priceMacbook = new Price();
        priceMacbook.setCurrency("INR");
        priceMacbook.setAmount(200000);
        priceMacbook.setDiscount(0);

        Price priceWatch = new Price();
        priceWatch.setCurrency("INR");
        priceWatch.setAmount(40000);
        priceWatch.setDiscount(0);


        priceIphone = priceRepository.save(priceIphone);
        priceMacbook = priceRepository.save(priceMacbook);
        priceWatch = priceRepository.save(priceWatch);

        Product iphone = new Product();
        iphone.setTitle("Iphone 15 Pro");
        iphone.setDescription("Best Iphone Ever");
        iphone.setPrice(priceIphone);
        iphone.setCategory(electronics);
        productRepository.save(iphone);

        Product macBook = new Product();
        macBook.setTitle("Macbook Pro 16");
        macBook.setDescription("Best Mac Ever");
        macBook.setPrice(priceMacbook);
        macBook.setCategory(electronics);
        productRepository.save(macBook);

        Product watch = new Product();
        watch.setTitle("Watch Series 9");
        watch.setDescription("Health on your wrist");
        watch.setPrice(priceWatch);
        watch.setCategory(electronics);
        productRepository.save(watch);


        Order order = new Order();
        order.setProductList(List.of(iphone,macBook,watch));
        order = orderRepository.save(order);
    }
}
