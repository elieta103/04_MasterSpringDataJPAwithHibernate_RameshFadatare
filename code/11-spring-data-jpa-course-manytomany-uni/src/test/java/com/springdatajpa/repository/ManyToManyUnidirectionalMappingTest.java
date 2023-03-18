package com.springdatajpa.repository;

import com.springdatajpa.entity.manytomany.unidirectional.Role;
import com.springdatajpa.entity.manytomany.unidirectional.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class ManyToManyUnidirectionalMappingTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUserTest(){
        User user = User.builder()
                .firstName("Eliel")
                .lastName("Herrera")
                .email("gresshel@gmail.com")
                .password("12345")
                .build();
        Role admin = Role.builder()
                .name("ROLE_ADMIN")
                .build();
        Role customer = Role.builder()
                .name("ROLE_CUSTOMER")
                .build();

        Set<Role> roles = new HashSet<>();
        roles.add(admin);
        roles.add(customer);

        user.setRoles(roles);

        userRepository.save(user);

    }

    @Test
    void updateUserTest(){
        User user = userRepository.findById(1L).get();
        user.setFirstName("Eliel Upd");
        user.setEmail("gresshel@gmail.com_Upd");

        Role roleUser = Role.builder()
                .name("ROLE_USER")
                .build();

        user.getRoles().add(roleUser);

        userRepository.save(user);
    }

    @Test
    void fetchUserTest(){
        User user = userRepository.findById(1L).get();
        System.out.println("**** User mail : "+user.getEmail());
        user.getRoles().forEach(role -> System.out.println("** Role : "+role.getName()));
    }

    @Test
    void deleteUserTest(){
      userRepository.deleteById(1L);
    }
}
