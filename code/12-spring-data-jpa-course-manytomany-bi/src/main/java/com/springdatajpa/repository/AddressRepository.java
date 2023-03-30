package com.springdatajpa.repository;

import com.springdatajpa.entity.manytomany.bidirectional.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
