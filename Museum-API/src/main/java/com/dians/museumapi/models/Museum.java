package com.dians.museumapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "museums")
public class Museum {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "museum_id")
    private Long museumId;

    @Column(name = "museum_name")
    private String museumName;

    private String city;

    private String address;

    private String email;

    @Column(name = "working_hours")
    private String workingHours;

    private String phone;

    private String website;

    @NonNull
    private String location;

    public Museum(String museumName, String city, String address, String email, String workingHours, String phone, String website, @NonNull String location) {
        this.museumName = museumName;
        this.city = city;
        this.address = address;
        this.email = email;
        this.workingHours = workingHours;
        this.phone = phone;
        this.website = website;
        this.location = location;
    }
}
