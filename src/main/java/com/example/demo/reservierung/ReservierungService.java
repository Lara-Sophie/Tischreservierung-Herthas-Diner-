package com.example.demo.reservierung;

import com.example.demo.kunde.Kunde;
import com.example.demo.kunde.KundeRepository;


import com.example.demo.tischReservierung.TischSlot;
import com.example.demo.tischReservierung.TischSlotRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class ReservierungService {

    @Autowired
    private ReservierungRepository reservierungRepository;

    @Autowired
    private TischSlotRepository tischSlotRepository;

    @Autowired
    private KundeRepository kundeRepository;

    Logger logger = LoggerFactory.getLogger(Reservierung.class);

    public Reservierung save(ReservierungBody reservierungBody) {
        Reservierung reservierung = new Reservierung();
        reservierung.setId(1);
        Kunde kunde = kundeRepository.findById(reservierungBody.getKundenId()).orElseThrow(() -> new RuntimeException("Kunde nicht gefunden"));
        kunde.addReservierung(reservierung);
        reservierung.setKunde(kunde);

        TischSlot tischSlot = tischSlotRepository.findById(reservierungBody.getTischSlotId()).orElseThrow(() -> new RuntimeException("TischSlot nicht gefunden"));
        tischSlot.setReservierung(reservierung);
        reservierung.setTischSlot(tischSlot);
        tischSlot.setReserviert(true);

        return reservierungRepository.save(reservierung);
    }


    public void delete(int id) {
        Reservierung reservierung = reservierungRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservierung nicht gefunden"));
        Kunde kunde = reservierung.getKunde();
        kunde.removeReservierung(reservierung);

        TischSlot tischSlot = reservierung.getTischSlot();
        tischSlot.setReservierung(null);
        tischSlot.setReserviert(false);
        reservierungRepository.deleteById(id);
    }

    public Reservierung get(int id) {
        return reservierungRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservierung nicht gefunden"));
    }

    public List<Reservierung> getAll() {
        return reservierungRepository.findAll();
    }
    }



