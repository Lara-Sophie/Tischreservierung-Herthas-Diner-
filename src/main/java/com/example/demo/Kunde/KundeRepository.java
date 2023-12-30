package com.example.demo.Kunde;

import org.springframework.data.jpa.repository.JpaRepository;


    public interface KundeRepository extends JpaRepository<Kunde, Integer> {
        // Standard JPA Repository-Methoden
    }


