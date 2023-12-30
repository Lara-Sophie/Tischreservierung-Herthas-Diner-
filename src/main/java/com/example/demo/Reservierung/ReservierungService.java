package com.example.demo.Reservierung;

import com.example.demo.Kunde.Kunde;
import com.example.demo.Kunde.KundeRepository;
import com.example.demo.Tisch.Tisch;
import com.example.demo.Tisch.TischRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservierungService {

    @Autowired
    private ReservierungRepository repository;

    @Autowired
    private TischRepository tischRepository;

    @Autowired
    private KundeRepository kundeRepository;

    public Reservierung save(Reservierung reservierung) {
        return repository.save(reservierung);
    }


    public void delete(int id) {repository.deleteById(id);}

    public Reservierung get(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Reservierung nicht gefunden"));
    }

    public List<Reservierung> getAll() {
        return repository.findAll();
    }

    public Reservierung createReservierung(Long kundenId, List<Long> tischIds, LocalDateTime startZeit, LocalDateTime endZeit) {
        // Hole Kunde und Tische basierend auf IDs
        Optional<Kunde> kundeOptional = Optional.ofNullable(kundeRepository.findById(kundenId));
        Kunde kunde = kundeOptional.orElseThrow(() -> new EntityNotFoundException("Kunde mit ID " + kundenId + " wurde nicht gefunden."));

        List<Tisch> tische = tischRepository.findAllById(tischIds);

        // Überprüfe die Verfügbarkeit jedes Tisches
        for (Tisch tisch : tische) {
            if (!isTischVerfuegbar(tisch, startZeit, endZeit)) {
                throw new RuntimeException("Tisch " + tisch.getId() + " ist im gewählten Zeitraum nicht verfügbar.");
            }
        }

        // Erstelle eine neue Reservierung
        Reservierung reservierung = new Reservierung();
        reservierung.setKunde(kunde);
        reservierung.setTische(tische);
        reservierung.setStartzeit(startZeit);
        reservierung.setEndzeit(endZeit);

        return repository.save(reservierung);
    }

    private boolean isTischVerfuegbar(Tisch tisch, LocalDateTime start, LocalDateTime ende) {
        // Implementiere Logik, um zu überprüfen, ob der Tisch im angegebenen Zeitraum verfügbar ist.
        // Dies könnte ein Aufruf an das Repository sein, um bestehende Reservierungen zu überprüfen.
        return true; // Beispielimplementation
    }
}
