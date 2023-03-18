package com.springdatajpa.repository;

import com.springdatajpa.entity.onetoone.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
