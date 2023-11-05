package com.dians.museumapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "museums")
public class Museum {
    @Id
    @Column(name = "museum_id")
    private Long museumId;

    @Column(name = "museum_name")
    private String museumName;

    private String city;

    private String address;
}
