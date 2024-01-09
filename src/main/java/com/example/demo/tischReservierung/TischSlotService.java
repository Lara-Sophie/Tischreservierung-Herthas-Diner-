package com.example.demo.tischReservierung;

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

    public TischSlot save(TischSlotBody tischSlotBody) {
        TischSlot tischSlot = new TischSlot();

        tischSlot.setStartzeit(tischSlotBody.getStartzeit());
        tischSlot.setEndzeit(tischSlotBody.getStartzeit().plusHours(1));
        tischSlot.setReserviert(false);

        Tisch tisch = tischRepository.findById(tischSlotBody.getTischId()).orElseThrow(() -> new RuntimeException("Tisch nicht gefunden"));
        tischSlot.setTisch(tisch);

        return repository.save(tischSlot);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public TischSlot get(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("TischSlot nicht gefunden"));
    }

    public List<TischSlot> getAll(){ return repository.findAll();}



}
