package com.example.demo.tisch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TischService {

    @Autowired
    private TischRepository repository;

    public Tisch save(Tisch tisch) {
        return repository.save(tisch);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public Tisch get(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tisch nicht gefunden"));
    }

    public List<Tisch> getAll() {
        return repository.findAll();
    }
}