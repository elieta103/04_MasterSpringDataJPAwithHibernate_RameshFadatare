package com.springdatajpa.repository;

import com.springdatajpa.entity.onetomany.unidirectional.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
