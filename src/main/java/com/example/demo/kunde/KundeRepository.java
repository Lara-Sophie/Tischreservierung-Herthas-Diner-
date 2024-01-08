package com.example.demo.kunde;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface KundeRepository extends JpaRepository<Kunde, Integer> {
        Optional<Kunde> findById(Long kundenId);
        // Standard JPA Repository-Methoden
    }


