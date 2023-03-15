package com.springdatajpa.repository;

import com.springdatajpa.entity.onetomany.bidirectional.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
