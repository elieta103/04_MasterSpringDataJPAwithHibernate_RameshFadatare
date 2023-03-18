package com.springdatajpa.repository;

import com.springdatajpa.entity.manytomany.unidirectional.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
