package com.springdatajpa.repository;


import com.springdatajpa.entity.onetoone.bidirectional.Address;
import com.springdatajpa.entity.onetoone.bidirectional.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneBidirectionalMappingTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void saveAddressTest(){
        Order order = Order.builder()
                .orderTrackingNumber("1000ABC")
                .totalQuantity(5)
                .status("IN PROGRESS")
                .totalPrice(new BigDecimal("1000"))
                .build();

        Address address = Address.builder()
                .city("Mexico")
                .street("Guanajuato 198")
                .state("Mexico")
                .country("Mexico")
                .zipCode("54150")
                .build();

        order.setBillingAddress(address);
        address.setOrder(order);

        addressRepository.save(address);
    }

    @Test
    void getAddressTest(){
        Address address = addressRepository.findById(1L).get();
        //System.out.println("Order from Address : "+ address.getOrder());
        /*
        If you print the address then it will call the toString()
        method of the Address class object and it intern call the toString method of the Order class object.
        This call chain goes infinite and leads to Stack Overflow Error.
        Assert the result instead of printing the result.
         */
    }

    @Test
    void updateAddressTest(){
        Address address = addressRepository.findById(1L).get();
        address.setZipCode("010203");

        address.getOrder().setStatus("DELIVERED");

        addressRepository.save(address);
    }

    @Test
    void deleteAddressTest(){
        addressRepository.deleteById(1L);
    }
}
