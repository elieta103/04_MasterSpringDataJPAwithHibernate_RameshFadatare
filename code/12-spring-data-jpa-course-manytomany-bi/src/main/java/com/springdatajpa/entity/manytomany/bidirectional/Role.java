package com.springdatajpa.entity.manytomany.bidirectional;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE},
                fetch = FetchType.EAGER,
                mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
