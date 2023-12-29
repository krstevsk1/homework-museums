package com.dians.userauthentication.userauthentication.repositories;

import com.dians.userauthentication.userauthentication.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MuseumRepo extends JpaRepository<Museum, Long> {
    Optional<Museum> findByMuseumName(String museumName);
    Optional<List<Museum>> findByMuseumNameContainingIgnoreCase(String searchTerm);
}
