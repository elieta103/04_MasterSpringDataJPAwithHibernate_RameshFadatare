package com.springdatajpa.repository;

import com.springdatajpa.entity.manytomany.unidirectional.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
