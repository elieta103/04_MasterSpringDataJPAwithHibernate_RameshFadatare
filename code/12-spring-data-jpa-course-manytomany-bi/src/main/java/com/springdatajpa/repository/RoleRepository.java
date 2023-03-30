package com.springdatajpa.repository;

import com.springdatajpa.entity.manytomany.bidirectional.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
