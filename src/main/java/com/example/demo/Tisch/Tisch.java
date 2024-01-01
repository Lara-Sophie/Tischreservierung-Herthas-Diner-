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
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "tische")
public class Tisch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "belegt")
    private boolean reserviert;
    @Column(name = "anzahlplaetze")
    private int anzahlPlaetze;
    @ManyToMany(mappedBy = "tische")
    private List<Reservierung> reservierungen;



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

    public boolean isReserviert() {
        return reserviert;
    }

    public void setReserviert(boolean reserviert) {
        this.reserviert = reserviert;
    }

    public List<Reservierung> getReservierung() {
        return reservierungen;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tisch tisch)) return false;
        return getId() == tisch.getId() && getAnzahlPlaetze() == tisch.getAnzahlPlaetze() && isReserviert() == tisch.isReserviert() && Objects.equals(getReservierung(), tisch.getReservierung());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAnzahlPlaetze(), isReserviert(), getReservierung());
    }
}
