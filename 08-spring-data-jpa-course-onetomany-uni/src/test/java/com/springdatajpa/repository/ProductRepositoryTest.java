package com.springdatajpa.repository;

import com.springdatajpa.entity.onetomany.unidirectional.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private  ProductRepository productRepository;

    @Test
    void  saveProductTest(){
        //create product
        Product product = Product.builder()
                .name("Product 1")
                .description("Description Product 1")
                .sku("100ABC")
                .price(new BigDecimal(100))
                .active(true)
                .imageUrl("product1.png")
                .build();

        //save product
        Product productSaved = productRepository.save(product);

        //display info product
        assertThat(productSaved.getId()).isNotNull();
        System.out.println(productSaved.toString());

    }

    @Test
    void  updateProductTest(){
        //find entity an entity by id product
        Long id = 3L;
        Product product = productRepository.findById(id).get();

        //update info
        product.setName("update product 1");
        product.setDescription("updated desc product 1");

        //save product
        Product productSaved = productRepository.save(product);

        //display info product
        assertThat(productSaved.getId()).isNotNull();
        System.out.println(productSaved.toString());

    }

    @Test
    void findByIdTest(){
        Long id = 3L;

        Product product = productRepository.findById(id).get();
        assertThat(product).isNotNull();
    }

    @Test
    void saveAllTest(){
        Product product10 = Product.builder()
                .name("Product 10")
                .description("Description Product 10")
                .sku("10000ABC")
                .price(new BigDecimal(100))
                .active(true)
                .imageUrl("product10.png")
                .build();
        Product product20 = Product.builder()
                .name("Product 20")
                .description("Description Product 20")
                .sku("200ABC")
                .price(new BigDecimal(100))
                .active(true)
                .imageUrl("product20.png")
                .build();
        Product product30 = Product.builder()
                .name("Product 30")
                .description("Description Product 30")
                .sku("300ABC")
                .price(new BigDecimal(100))
                .active(true)
                .imageUrl("product30.png")
                .build();

        productRepository.saveAll(List.of(product10, product20, product30));
    }

    @Test
    void findAllTest(){
        List<Product> products = productRepository.findAll();

        products.forEach(System.out::println);
    }

    @Test
    void deleteByIdTest(){
        Long id = 3L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteTest(){
        Long id = 4L;
        Product productToDelete = productRepository.findById(id).get();
        productRepository.delete(productToDelete);
    }

    @Test
    void deleteAllTest(){
        productRepository.deleteAll();
    }

    @Test
    void countTest(){
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsById(){
        boolean exists = productRepository.existsById(1L);
        System.out.println("Exists id 1 ?  : "+exists);
    }
}