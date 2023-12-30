package com.example.demo.Reservierung;

import com.example.demo.Kunde.Kunde;
import com.example.demo.Tisch.Tisch;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Reservierung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "kunde_id")
    private Kunde kunde;

    @OneToMany(mappedBy = "reservierung", cascade = CascadeType.ALL)
    private List<Tisch> tische;

    private LocalDate datum;
    private LocalTime zeit;
    private int personen;


}
