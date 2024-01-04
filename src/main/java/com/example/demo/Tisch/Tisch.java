package com.example.demo.Tisch;

<<<<<<< HEAD:src/main/java/com/example/demo/Tisch.java
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Tisch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id = 1;
    int anzahlPlaetze;
    boolean reserviert;



    //public Tisch(int id, int anzahlPlaetze, boolean reserviert) {
    //this.id = id;
    //this.anzahlPlaetze = anzahlPlaetze;
    //this.reserviert = reserviert;
    //}
=======


import com.example.demo.Reservierung.Reservierung;
import com.example.demo.ReservierungTische.ReservierungTische;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "tische")
public class Tisch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "anzahlplaetze")
    private int anzahlPlaetze;
    @OneToMany(mappedBy = "tisch")
    private List<ReservierungTische> reservierungTische = new LinkedList<>();



public Tisch() {
        // Default constructor required by JPA
    }
>>>>>>> 9c65e663e34e9cc6f3ca3e2469e0c1dd580a2006:src/main/java/com/example/demo/Tisch/Tisch.java



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnzahlPlaetze() {
        return anzahlPlaetze;
    }

    public void setAnzahlPlaetze(int anzahlPlaetze) {
        this.anzahlPlaetze = anzahlPlaetze;
    }






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tisch tisch)) return false;
        return getId() == tisch.getId() && getAnzahlPlaetze() == tisch.getAnzahlPlaetze() && Objects.equals(reservierungTische, tisch.reservierungTische);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAnzahlPlaetze(), reservierungTische);
    }
}
