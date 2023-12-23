package com.dians.museumapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class User {

    @Id
    @Column(unique = true)
    private String username;

    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Museum> museums;
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.museums = new ArrayList<>();
    }

    public User() {
        this.museums = new ArrayList<>();
    }
}
