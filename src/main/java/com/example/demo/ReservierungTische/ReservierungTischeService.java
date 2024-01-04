package com.example.demo.ReservierungTische;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservierungTischeService {

    @Autowired
    private ReservierungTischeRepository repository;


    public List<ReservierungTische> getReservierungTischeByTischId(Integer tischId) {
        return repository.findReservierungTischeByTischId(tischId);
    }
    public List<ReservierungTische> getReservierungTischeByReservierungId(Integer reservierungId) {
        return repository.findReservierungTischeByReservierungId(reservierungId);
    }
}
