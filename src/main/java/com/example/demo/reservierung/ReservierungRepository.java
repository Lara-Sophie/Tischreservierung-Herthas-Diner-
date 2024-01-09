package com.example.demo.reservierung;

import com.example.demo.tisch.Tisch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ReservierungRepository extends JpaRepository<Reservierung, Integer> {
    // Standard JPA Repository-Methoden
    Optional<Reservierung> findById(Integer tischId);
}
