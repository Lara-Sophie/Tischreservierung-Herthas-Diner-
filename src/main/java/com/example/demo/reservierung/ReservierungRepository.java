package com.example.demo.reservierung;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservierungRepository extends JpaRepository<Reservierung, Integer> {
    // Standard JPA Repository-Methoden

}
