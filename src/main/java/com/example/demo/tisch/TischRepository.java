package com.example.demo.tisch;

import com.example.demo.kunde.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TischRepository extends JpaRepository<Tisch, Integer> {


    Optional<Tisch> findById(Integer tischId);

}
