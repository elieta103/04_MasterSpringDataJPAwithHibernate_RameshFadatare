package com.springdatajpa.repository;

import com.springdatajpa.entity.manytomany.bidirectional.Role;
import com.springdatajpa.entity.manytomany.bidirectional.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootTest
public class ManyToManyBidirectionalMappingTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void saveRoleTest(){
        User user1 = User.builder()
                .firstName("Eliel")
                .lastName("Herrera")
                .email("gresshel@gmail.com")
                .password("12345")
                .build();
        User user2 = User.builder()
                .firstName("Ian")
                .lastName("Herrera")
                .email("ian@gmail.com")
                .password("12345")
                .build();

        Role admin = Role.builder()
                .name("ROLE_ADMIN")
                .build();

        Set<User> users = new HashSet<>();
        users.add(user1);
        users.add(user2);

        Set<Role> roles= new HashSet<>();
        roles.add(admin);

        user1.setRoles(roles);
        user2.setRoles(roles);
        admin.setUsers(users);

        roleRepository.save(admin);
    }


    @Test
    void fetchRoleTest(){
        List<Role> roleList = roleRepository.findAll();
        roleList.forEach(item -> {
            System.out.println("Role : "+item.getName());
            item.getUsers().stream().forEach(user -> {
                System.out.println("User : "+user.getFirstName()+" "+user.getLastName());
            });
        });
    }

}
