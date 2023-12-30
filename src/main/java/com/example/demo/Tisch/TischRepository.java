package com.example.demo.Tisch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TischRepository extends JpaRepository<Tisch, Integer> {
    List<Tisch> findAllById(List<Long> tischIds);
    // Standard JPA Repository-Methoden
}
