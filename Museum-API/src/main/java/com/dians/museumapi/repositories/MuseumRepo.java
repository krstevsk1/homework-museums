package com.dians.museumapi.repositories;

import com.dians.museumapi.models.Museum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MuseumRepo extends JpaRepository<Museum, Long> {
    Optional<Museum> findByMuseumName(String museumName);
    Optional<List<Museum>> findByMuseumNameContainingIgnoreCase(String searchTerm);
}
