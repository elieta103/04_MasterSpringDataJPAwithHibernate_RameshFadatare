package com.springdatajpa.repository;


import com.springdatajpa.entity.onetomany.unidirectional.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){

        Product product = productRepository.findByName("Product 10");

        System.out.println("---------------------- Inicio Resultados --------------------------------");
        System.out.println("Id : "+ product.getId());
        System.out.println("Nombre : "+product.getName());
        System.out.println("Descripcion : " +product.getDescription());
        System.out.println("---------------------- Fin Resultados --------------------------------");
    }

    @Test
    void findByIdMethod(){
        Product product = productRepository.findById(7L).get();

        System.out.println("---------------------- Inicio Resultados --------------------------------");
        System.out.println("Id : "+ product.getId());
        System.out.println("Nombre : "+product.getName());
        System.out.println("Descripcion : " +product.getDescription());
        System.out.println("---------------------- Fin Resultados --------------------------------");
    }

    @Test
    void findByNameOrDescriptionMethod(){

        List<Product> products = productRepository.findByNameOrDescription("Product 10",
                "Description Product 10");

        System.out.println("---------------------- Inicio Resultados --------------------------------");

        products.forEach((p) -> {
            System.out.println("Id : "+ p.getId());
            System.out.println("Name : "+p.getName());
            System.out.println("Desc : "+p.getDescription());
        });
        System.out.println("---------------------- Final Resultados --------------------------------");

    }

    @Test
    void findByNameAndDescriptionMethod(){

        List<Product> products = productRepository.findByNameAndDescription("Product 10",
                "Description Product 10");

        System.out.println("---------------------- Inicio Resultados --------------------------------");
        products.forEach((p) -> {
            System.out.println("Id : "+ p.getId());
            System.out.println("Name : "+p.getName());
            System.out.println("Desc : "+p.getDescription());
        });
        System.out.println("---------------------- Final Resultados --------------------------------");
    }

    @Test
    void findDistinctByNameMethod(){
        Product product = productRepository.findDistinctByName("Product 10");

        System.out.println("---------------------- Inicio Resultados --------------------------------");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
        System.out.println("---------------------- Final Resultados --------------------------------");
    }

    @Test
    void findByPriceGreaterThanMethod(){
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(10));

        System.out.println("---------------------- Inicio Resultados --------------------------------");
        products.forEach((p) -> {
            System.out.println(p.getId()+" - "+p.getName()+" - $"+p.getPrice());
        });
        System.out.println("---------------------- Final Resultados --------------------------------");
    }

    @Test
    void findByPriceLessThanMethod(){

        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(200));
        System.out.println("---------------------- Inicio Resultados --------------------------------");
        products.forEach((p) -> {
            System.out.println(p.getId()+" - "+p.getName()+" - $"+p.getPrice());
        });
        System.out.println("---------------------- Final Resultados --------------------------------");
    }

    @Test
    void findByNameContainingMethod(){

        List<Product> products = productRepository.findByNameContaining("Product");
        System.out.println("---------------------- Inicio Resultados --------------------------------");
        products.forEach((p) -> {
            System.out.println(p.getId()+" - "+p.getName()+" - $"+p.getPrice());
        });
        System.out.println("---------------------- Final Resultados --------------------------------");
    }

    @Test
    void findByNameLikeMethod(){

        List<Product> products = productRepository.findByNameLike("Product 1");
        System.out.println("---------------------- Inicio Resultados --------------------------------");
        products.forEach((p) -> {
            System.out.println(p.getId()+" - "+p.getName()+" - $"+p.getPrice());
        });
        System.out.println("---------------------- Final Resultados --------------------------------");
    }

    @Test
    void findByPriceBetweenMethod(){
        List<Product> products = productRepository.findByPriceBetween(
                new BigDecimal(101), new BigDecimal(299)
        );

        System.out.println("---------------------- Inicio Resultados --------------------------------");
        products.forEach((p) -> {
            System.out.println(p.getId()+" - "+p.getName()+" - $"+p.getPrice());
        });
        System.out.println("---------------------- Final Resultados --------------------------------");

    }

    @Test
    void findByDateCreatedBetweenMethod(){

        // start date
        LocalDateTime startDate = LocalDateTime.of(2023,02,17,18,52,33);
        // end date
        LocalDateTime endDate = LocalDateTime.of(2023,02,17,18,57,33);

        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);

        System.out.println("---------------------- Inicio Resultados --------------------------------");
        products.forEach((p) -> {
            System.out.println(p.getId()+" - "+p.getName()+" - $"+p.getPrice()+" - "+p.getDateCreated());
        });
        System.out.println("---------------------- Final Resultados --------------------------------");

    }

    @Test
    void findByNameInMethod(){

        List<Product> products = productRepository.findByNameIn(List.of("Product 10", "Product 20"));
        System.out.println("---------------------- Inicio Resultados --------------------------------");
        products.forEach((p) -> {
            System.out.println(p.getId()+" - "+p.getName()+" - $"+p.getPrice()+" - "+p.getDateCreated());
        });
        System.out.println("---------------------- Final Resultados --------------------------------");
    }

    @Test
    void findFirst2ByOrderByNameAscMethod(){
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
        System.out.println("---------------------- Inicio Resultados --------------------------------");
        products.forEach((p) -> {
            System.out.println(p.getId()+" - "+p.getName()+" - $"+p.getPrice()+" - "+p.getDateCreated());
        });
        System.out.println("---------------------- Final Resultados --------------------------------");
    }

    @Test
    void findTop2ByOrderByPriceDescMethod(){
        List<Product> products = productRepository.findTop2ByOrderByPriceDesc();
        System.out.println("---------------------- Inicio Resultados --------------------------------");
        products.forEach((p) -> {
            System.out.println(p.getId()+" - "+p.getName()+" - $"+p.getPrice()+" - "+p.getDateCreated());
        });
        System.out.println("---------------------- Final Resultados --------------------------------");

    }
}
