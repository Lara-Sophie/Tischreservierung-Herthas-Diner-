package com.example.demo.Reservierung;

import com.example.demo.Kunde.Kunde;
import com.example.demo.Kunde.KundeRepository;
import com.example.demo.ReservierungTische.ReservierungTische;
import com.example.demo.ReservierungTische.ReservierungTischeRepository;
import com.example.demo.Tisch.Tisch;
import com.example.demo.Tisch.TischRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservierungService {

    @Autowired
    private ReservierungRepository reservierungRepository;

    @Autowired
    private TischRepository tischRepository;

    @Autowired
    private ReservierungTischeRepository reservierungTischeRepository;

    @Autowired
    private KundeRepository kundeRepository;



    public Reservierung get(int id) {
        return reservierungRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservierung nicht gefunden"));
    }

    public List<Reservierung> getAll() {
        return reservierungRepository.findAll();
    }


    public Reservierung createReservierung(Integer kundenId, List<Integer> tischIds, LocalDateTime startZeit, LocalDateTime endZeit, int personen) throws TableNotAvailableException, InvalidReservationTimeException {
        validateTimeRange(startZeit, endZeit);

        Kunde kunde = kundeRepository.findById(kundenId)
                .orElseThrow(() -> new EntityNotFoundException("Kunde mit ID " + kundenId + " wurde nicht gefunden."));

        List<Tisch> tische = tischRepository.findAllById(tischIds);
        List<Tisch> tischeMitReservierungen = findTischeByReservierungTische(tischIds, startZeit, endZeit);

        validateTableAvailability(tische, tischeMitReservierungen);

        Reservierung reservierung = buildReservierung(kunde, startZeit, endZeit, personen);
        List<ReservierungTische> reservierungTische = buildReservierungTische(reservierung, tische);

        reservierungTischeRepository.saveAll(reservierungTische);
        return reservierungRepository.save(reservierung);
    }

    @Transactional
    public void deleteReservierung(Integer reservierungId) {
        // Find the reservation by its ID
        Reservierung reservierung = reservierungRepository.findById(reservierungId)
                .orElseThrow(() -> new EntityNotFoundException("Reservierung mit ID " + reservierungId + " wurde nicht gefunden."));

        // Delete all associated ReservierungTische entries
        List<ReservierungTische> reservierungTische = reservierungTischeRepository.findByReservierung(reservierung);
        reservierungTischeRepository.deleteAll(reservierungTische);

        // Finally, delete the reservation itself
        reservierungRepository.delete(reservierung);
    }


    private void validateTimeRange(LocalDateTime start, LocalDateTime end) throws InvalidReservationTimeException {
        if (start.isAfter(end)) {
            throw new InvalidReservationTimeException("Startzeit muss vor Endzeit liegen.");
        }
    }

    private void validateTableAvailability(List<Tisch> requestedTables, List<Tisch> reservedTables) throws TableNotAvailableException {
        for (Tisch tisch : requestedTables) {
            if (reservedTables.contains(tisch)) {
                throw new TableNotAvailableException("Tisch " + tisch.getId() + " ist nicht verfügbar.");
            }
        }
    }

    private Reservierung buildReservierung(Kunde kunde, LocalDateTime startZeit, LocalDateTime endZeit, int personen) {
        Reservierung reservierung = new Reservierung();
        reservierung.setPersonen(personen);
        reservierung.setKunde(kunde);
        reservierung.setStartzeit(startZeit);
        reservierung.setEndzeit(endZeit);
        return reservierung;
    }

    private List<ReservierungTische> buildReservierungTische(Reservierung reservierung, List<Tisch> tische) {
        return tische.stream()
                .map(tisch -> new ReservierungTische(reservierung, tisch, true))
                .collect(Collectors.toList());
    }


    private List<Tisch> findTischeByReservierungTische(List<Integer> tischIds, LocalDateTime startZeit, LocalDateTime endZeit) {

        List<Tisch> alleTische = tischRepository.findAll();

        // Liste von allen Reservierungen, die die ausgewählten Tische zur gewünschten Zeit beinhalten
        List<ReservierungTische> reservierung_Tische = tischIds.stream()
                .flatMap(tischId -> reservierungTischeRepository.findReservierungTischeByTischIdAndStartzeitBetweenAndEndzeitBetween(tischId,startZeit,endZeit).stream())
                .toList();

        List<Tisch> tischeMitReservierungen = reservierung_Tische.stream()
                .map(reservierungTisch -> alleTische.stream()
                    .filter(tisch -> tisch.getId() == reservierungTisch.getReservierungtischeID().getTischid())
                        .findFirst().orElse(null))
                .filter(Objects::nonNull)
                .toList();

        return tischeMitReservierungen;
    }

}
