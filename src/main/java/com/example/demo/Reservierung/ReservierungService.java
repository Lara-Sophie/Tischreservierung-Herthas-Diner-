package com.example.demo.Reservierung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservierungService {

    @Autowired
    private ReservierungRepository repository;

    public Reservierung save(Reservierung reservierung) {
        return repository.save(reservierung);
    }

    public Reservierung get(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Reservierung nicht gefunden"));
    }

    public List<Reservierung> getAll() {
        return repository.findAll();
    }

    // Weitere Methoden nach Bedarf
}
