package com.springdatajpa.repository;

import com.springdatajpa.entity.onetomany.bidirectional.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NativeSQLQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionSQLIndexParamMethod(){

        Product product = productRepository.findByNameOrDescriptionSQLIndexParam(
                "Product 10", "Product 10 Description"
        );

        System.out.println("---------------------- Inicio Resultados --------------------------------");
        System.out.println(product.toString());
        System.out.println("---------------------- Final Resultados --------------------------------");
    }

    @Test
    void findByNameOrDescriptionSQLNamedParamMethod(){
        Product product = productRepository.findByNameOrDescriptionSQLNamedParam("Product 10"
                        , "Product 10 Description");

        System.out.println("---------------------- Inicio Resultados --------------------------------");
        System.out.println(product.toString());
        System.out.println("---------------------- Final Resultados --------------------------------");
    }
}
