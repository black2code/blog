package com.example.blog.user.model;

import com.example.blog.auditing.Auditable;
import jakarta.persistence.*;
import lombok.Getter;


@Table(name = "users")
@Getter
@Entity
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

}
