package com.springdatajpa.entity.manytomany.bidirectional;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_categories")
@Getter
@Setter
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private String categoryDescription;

    @OneToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
    }, fetch = FetchType.LAZY,
    mappedBy = "category")
    private List<Product> products = new ArrayList<>();
}
