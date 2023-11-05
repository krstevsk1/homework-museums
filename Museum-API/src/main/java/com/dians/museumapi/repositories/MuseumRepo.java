package com.dians.museumapi.repositories;

import com.dians.museumapi.models.Museum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseumRepo extends JpaRepository<Museum, Long> {

}
