package com.springdatajpa.repository;

import com.springdatajpa.entity.manytomany.bidirectional.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
