package com.springdatajpa.repository;

import com.springdatajpa.entity.manytomany.unidirectional.Product;
import com.springdatajpa.entity.manytomany.unidirectional.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    void saveProductCategoryTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("books");
        productCategory.setCategoryDescription("books description");

        Product product1 = new Product();
        product1.setName("Core java");
        product1.setPrice(new BigDecimal("1000"));
        product1.setImageUrl("image1.png");
        product1.setSku("ABCD");
        product1.setActive(true);

        Product product2 = new Product();
        product2.setName("Effective Java");
        product2.setPrice(new BigDecimal("2000"));
        product2.setImageUrl("image2.png");
        product2.setSku("ABCDE");
        product2.setActive(true);

        product1.setCategory(productCategory);
        product2.setCategory(productCategory);
        productCategory.setProducts(List.of(product1, product2));

        productCategoryRepository.save(productCategory);
    }

    @Test
    @Transactional
    void fetchProductCategory(){
        ProductCategory category = productCategoryRepository.findById(1L).get();
        // El fetch es Lazy, hasta este punto solo ha cargado el ProductCategory, no trae ningun producto
        System.out.println(category);
        // Lazy es sobre demanda, si no se agrega @Transactional, marca LazyInitializationException
        System.out.println(category.getProducts());

        // Otra Opcion es recorrer la relacion desde productos
        // List<Product> productList = productRepository.findByCategory(productCategory);
    }
}