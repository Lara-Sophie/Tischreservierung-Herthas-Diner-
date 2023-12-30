package com.example.demo.Kunde;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface KundeRepository extends JpaRepository<Kunde, Integer> {
        Kunde findById(Long kundenId);
        // Standard JPA Repository-Methoden
    }


