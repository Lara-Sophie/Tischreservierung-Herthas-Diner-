package com.example.demo.Tisch;
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
