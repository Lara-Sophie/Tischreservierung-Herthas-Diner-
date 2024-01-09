package com.example.demo.tisch;

import com.example.demo.kunde.Kunde;
import com.example.demo.reservierung.Reservierung;
import com.example.demo.tischReservierung.TischSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.tischReservierung.TischSlot;

import java.util.List;

@Service
public class TischService {

    @Autowired
    private TischRepository repository;

    @Autowired
    private TischSlotService TischSlotService;

    public Tisch save(Tisch tisch) {
        return repository.save(tisch);
    }

    public void delete(int id) {
        Tisch tisch = repository.findById(id).orElseThrow(() -> new RuntimeException("Kunde nicht gefunden"));
        List<TischSlot> tischSlots = tisch.getTischSlots();
        for (TischSlot tischSlot : tischSlots) {
            TischSlotService.delete(tischSlot.getTischslotid());
        }

        repository.deleteById(id);
    }

    public Tisch get(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tisch nicht gefunden"));
    }

    public List<Tisch> getAll() {
        return repository.findAll();
    }
}