package com.example.demo.kunde;

import com.example.demo.reservierung.ReservierungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KundeService {

    @Autowired
    private KundeRepository repository;

    private ReservierungService reservierungService;

    public Kunde save(Kunde kunde) {
        return repository.save(kunde);
    }

    public void delete(int id) {
        Kunde kunde = repository.findById(id).orElseThrow(() -> new RuntimeException("Kunde nicht gefunden"));
        kunde.getReservierung().forEach(reservierung -> {
            reservierungService.delete(reservierung.getId());
        });


        repository.deleteById(id);
    }

    public Kunde get(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Kunde nicht gefunden"));
    }

    public List<Kunde> getAll() {
        return repository.findAll();
    }
}
