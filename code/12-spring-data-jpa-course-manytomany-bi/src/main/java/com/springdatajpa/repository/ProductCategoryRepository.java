package com.springdatajpa.repository;

import com.springdatajpa.entity.manytomany.bidirectional.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
