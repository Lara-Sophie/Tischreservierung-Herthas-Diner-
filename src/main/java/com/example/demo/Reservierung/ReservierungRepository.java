package com.example.demo.Reservierung;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservierungRepository extends JpaRepository<Reservierung, Integer> {
    // Standard JPA Repository-Methoden
}
