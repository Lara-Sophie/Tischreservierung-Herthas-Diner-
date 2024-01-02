package com.example.demo.ReservierungTische;

import com.example.demo.Reservierung.Reservierung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ReservierungTischeRepository extends JpaRepository<ReservierungTische, Integer> {
    // Standard JPA Repository-Methoden
}
