package com.example.demo.Tisch;



import com.example.demo.Reservierung.Reservierung;
import jakarta.persistence.*;

@Entity
public class Tisch {
    @Id
    private int id;

    private int anzahlPlaetze;
    private boolean reserviert;

    @ManyToOne
    @JoinColumn(name = "reservierung_id")
    private Reservierung reservierung;

    // Standardkonstruktor, Getter, Setter, equals, hashCode
}
