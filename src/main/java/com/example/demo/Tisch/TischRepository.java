package com.example.demo.Tisch;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TischRepository extends JpaRepository<Tisch, Integer> {
    // Standard JPA Repository-Methoden
}
