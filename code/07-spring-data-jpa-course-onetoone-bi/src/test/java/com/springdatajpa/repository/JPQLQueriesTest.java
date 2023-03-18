package com.springdatajpa.repository;

import com.springdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPQLQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionJPQLIndexParamMethod(){
        Product product = productRepository.findByNameOrDescriptionJPQLIndexParam("Product 10",
                "Product 10 description");

        System.out.println("---------------------- Inicio Resultados --------------------------------");
        System.out.println(product.toString());
        System.out.println("---------------------- Final Resultados --------------------------------");
    }

    @Test
    void findByNameOrDescriptionJPQLNamedParamMethod(){

        Product product = productRepository.findByNameOrDescriptionJPQLNamedParam("Product 10",
                "Product 10 description");

        System.out.println("---------------------- Inicio Resultados --------------------------------");
        System.out.println(product.toString());
        System.out.println("---------------------- Final Resultados --------------------------------");
    }

}
