package com.anhae.drinkingLibrary.domain.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", length = 32, nullable = false, unique = true)
    private String email;
    @Column(length = 32, nullable = false)
    private String username;
}