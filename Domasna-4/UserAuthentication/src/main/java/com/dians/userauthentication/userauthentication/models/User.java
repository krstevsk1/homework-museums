package com.dians.userauthentication.userauthentication.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
@Data
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
        this.username = "";
        this.password = "";
        this.museums = new ArrayList<>();
    }
}
