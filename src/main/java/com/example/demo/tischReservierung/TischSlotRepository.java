package com.example.demo.tischReservierung;

import com.example.demo.tisch.Tisch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TischSlotRepository extends JpaRepository<TischSlot, Integer> {
    Optional<TischSlot> findById(Integer tischSlotId);
    // Standard JPA Repository-Methoden

}
