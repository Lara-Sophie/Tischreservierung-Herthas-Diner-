package com.example.demo.tischReservierung;

import com.example.demo.kunde.Kunde;
import com.example.demo.reservierung.Reservierung;
import com.example.demo.reservierung.ReservierungService;
import com.example.demo.tisch.Tisch;
import com.example.demo.tischReservierung.TischSlot;
import com.example.demo.tischReservierung.TischSlotRepository;
import com.example.demo.tischReservierung.TischSlotBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.tisch.TischRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TischSlotService {

    @Autowired
    private TischSlotRepository repository;

    @Autowired
    private TischRepository tischRepository;

    @Autowired
    private ReservierungService reservierungService;

    public TischSlot save(TischSlotBody tischSlotBody) {
        TischSlot tischSlot = new TischSlot();
        tischSlot.setTischslotid(1);

        String startzeit_String = tischSlotBody.getStartzeit();
        tischSlot.setStartzeit(LocalDateTime.parse(startzeit_String));
        tischSlot.setEndzeit(LocalDateTime.parse(startzeit_String).plusHours(2));
        tischSlot.setReserviert(false);

        Tisch tisch = tischRepository.findById(tischSlotBody.getTischId()).orElseThrow(() -> new RuntimeException("Tisch nicht gefunden"));
        tischSlot.setTisch(tisch);
        tisch.addTischSlot(tischSlot);

        return repository.save(tischSlot);
    }

    public void delete(int id) {
        TischSlot tischSlot = repository.findById(id).orElseThrow(() -> new RuntimeException("Kunde nicht gefunden"));
        Reservierung reservierung = tischSlot.getReservierung();

        if (reservierung != null) {
            reservierungService.delete(reservierung.getId());
        }
        repository.deleteById(id);
    }

    public TischSlot get(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("TischSlot nicht gefunden"));
    }

    public List<TischSlot> getAll(){ return repository.findAll();}



}
