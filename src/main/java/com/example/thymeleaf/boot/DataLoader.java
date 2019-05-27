package com.example.thymeleaf.boot;

import com.example.thymeleaf.model.Product;
import com.example.thymeleaf.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Product p1 = new Product();
        p1.setCategory("CellPhone");
        p1.setDescription("Google Pixel");
        p1.setName("Pixel 3XL");
        p1.setPrice(700.0);
        p1.setType("Android");

        productRepository.save(p1);

        Product p2 = new Product();
        p2.setCategory("CellPhone");
        p2.setDescription("Samsung");
        p2.setName("Galaxy 10");
        p2.setPrice(400.0);
        p2.setType("Android");

        productRepository.save(p2);
    }
}
