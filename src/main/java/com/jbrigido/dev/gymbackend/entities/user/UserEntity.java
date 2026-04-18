package com.jbrigido.dev.gymbackend.entities.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity(name = "Users")
@Table(name = "Users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String lastname;
    @Column(nullable = false)
    private LocalDate birthday;
    @Column(unique = true, length = 100)
    private String email;
    @Column(unique = true, length = 100)
    private String username;
    @Column(length = 40)
    private String password;
    @Column(columnDefinition = "boolean default 1")
    private Boolean status;
    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime created_at;

}
