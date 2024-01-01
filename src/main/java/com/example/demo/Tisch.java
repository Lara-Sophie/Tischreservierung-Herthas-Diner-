package com.example.demo;

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


    public int getId() {
        return id;
    }

    public int getAnzahlPlaetze() {
        return anzahlPlaetze;
    }

    public boolean isReserviert() {
        return reserviert;
    }



    public void setAnzahlPlaetze(int anzahlPlaetze) {
        this.anzahlPlaetze = anzahlPlaetze;
    }

    public void setReserviert(boolean reserviert) {
        this.reserviert = reserviert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tisch tisch)) return false;
        return getId() == tisch.getId() && getAnzahlPlaetze() == tisch.getAnzahlPlaetze() && isReserviert() == tisch.isReserviert();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAnzahlPlaetze(), isReserviert());
    }
}
