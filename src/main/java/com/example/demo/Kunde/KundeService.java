package com.example.demo.Kunde;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KundeService {

    @Autowired
    private KundeRepository repository;

    public Kunde save(Kunde kunde) {
        return repository.save(kunde);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public Kunde get(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Kunde nicht gefunden"));
    }

    public List<Kunde> getAll() {
        return repository.findAll();
    }
}
