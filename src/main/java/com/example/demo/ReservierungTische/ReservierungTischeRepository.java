package com.example.demo.ReservierungTische;

import com.example.demo.Reservierung.Reservierung;
import com.example.demo.Tisch.Tisch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservierungTischeRepository extends JpaRepository<ReservierungTische, Integer> {
    //
    default List<ReservierungTische> findAllById(List<Integer> tischIds) {
        return null;
    }

    List<ReservierungTische> findReservierungTischeByTischId(Integer TischIds);
    List<ReservierungTische> findReservierungTischeByReservierungId(Integer ReservierungIds);

    @Query("SELECT reservierungtischeID From ReservierungTische")
    List<ReservierungTische> findReservierungTischeByTischIdAndStartzeitBetweenAndEndzeitBetween(Integer tischId, LocalDateTime startzeit, LocalDateTime endzeit);

    List<ReservierungTische> findByReservierung(Reservierung reservierung);

}
