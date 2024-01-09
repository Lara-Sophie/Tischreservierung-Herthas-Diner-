package com.example.demo.tischReservierung;


import com.example.demo.tischReservierung.TischSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TischSlotRepository extends JpaRepository<TischSlot, Integer> {

    // Standard JPA Repository-Methoden
}
