package com.example.demo.reservierung;

import com.example.demo.kunde.Kunde;
import com.example.demo.kunde.KundeRepository;

import com.example.demo.tisch.Tisch;
import com.example.demo.tisch.TischRepository;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private KundeRepository kundeRepository;

    Logger logger = LoggerFactory.getLogger(Reservierung.class);

    public Reservierung get(int id) {
        return reservierungRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservierung nicht gefunden"));
    }

    public List<Reservierung> getAll() {
        return reservierungRepository.findAll();
    }



}
