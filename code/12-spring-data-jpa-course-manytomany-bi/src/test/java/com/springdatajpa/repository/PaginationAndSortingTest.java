package com.springdatajpa.repository;

import com.springdatajpa.entity.manytomany.bidirectional.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


@SpringBootTest
public class PaginationAndSortingTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void paginationTest(){
        int pageNo = 3;
        int pageSize = 5;

        //Create pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        //FindAll method and pass pageable instance
        Page<Product> page = productRepository.findAll(pageable);

        System.out.println("---------------------- Inicio Resultados --------------------------------");
        List<Product> products = page.getContent();
        products.forEach(System.out::println);

        System.out.println("Total de paginas : "+ page.getTotalPages());
        System.out.println("Total de elementos : "+ page.getTotalElements());
        System.out.println("Número de elementos : "+ page.getNumberOfElements());
        System.out.println("Tamaño : "+ page.getSize());
        System.out.println("Es ultimo ? : "+ page.isLast());
        System.out.println("Es primero ? : "+ page.isFirst());

        System.out.println("---------------------- Final Resultados --------------------------------");
    }

    @Test
    void sortingTest(){
        String sortBy = "price";
        String sortDir = "desc";

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending() :
                                                                         Sort.by(sortBy).descending();
        List<Product> productList = productRepository.findAll(sort);

        //List<Product> productList = productRepository.findAll(Sort.by(sortBy).ascending());


        System.out.println("---------------------- Inicio Resultados --------------------------------");
        productList.forEach(System.out::println);

        System.out.println("---------------------- Final Resultados --------------------------------");

    }


    @Test
    void sortingMultipleFieldTest(){
        String strName = "name";
        String strDesc = "description";
        String strDir = "desc";


        Sort sortByName = strDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(strName).ascending() :
                                                                              Sort.by(strName).descending();
        Sort sortByDesc = strDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(strDesc).ascending() :
                                                                              Sort.by(strDesc).descending();

        Sort groupBySort = sortByName.and(sortByDesc);

        List<Product> productList = productRepository.findAll(groupBySort);

        System.out.println("---------------------- Inicio Resultados --------------------------------");
        productList.forEach(System.out::println);
        System.out.println("---------------------- Final Resultados --------------------------------");

    }

    @Test
    void paginationAndSortingTogetherTest(){
        String strByPrice = "price";
        String strDir = "desc";
        int pageNo = 0;
        int pageSize = 5;

        //Sort Object
        Sort sort = strDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(strByPrice).ascending() :
                                                                         Sort.by(strByPrice).descending();

        //Pageable Object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> page = productRepository.findAll(pageable);

        System.out.println("---------------------- Inicio Resultados --------------------------------");
        List<Product> products = page.getContent();
        products.forEach(System.out::println);

        System.out.println("Total de paginas : "+ page.getTotalPages());
        System.out.println("Total de elementos : "+ page.getTotalElements());
        System.out.println("Número de elementos : "+ page.getNumberOfElements());
        System.out.println("Tamaño : "+ page.getSize());
        System.out.println("Es ultimo ? : "+ page.isLast());
        System.out.println("Es primero ? : "+ page.isFirst());

        System.out.println("---------------------- Final Resultados --------------------------------");

    }
}





