package com.example.demo.tisch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TischRepository extends JpaRepository<Tisch, Integer> {


    Optional<Tisch> findById(Integer tischId);

}
