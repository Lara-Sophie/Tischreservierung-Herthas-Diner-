package com.example.demo.tisch;
import com.example.demo.tischReservierung.TischSlot;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "tische")
public class Tisch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @Column(name = "anzahlplaetze")
    private int anzahlPlaetze;

    @JsonIgnore
    @OneToMany(mappedBy = "tisch")
    private List<TischSlot> tischSlots;


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

    public List<TischSlot> getTischSlots() {
        return tischSlots;
    }

    public void removeTisch(TischSlot tischSlot) {
        tischSlots.remove(tischSlot);
    }

    public void addTischSlot(TischSlot tischSlot) {
        tischSlots.add(tischSlot);
    }






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tisch tisch)) return false;
        return getId() == tisch.getId() && getAnzahlPlaetze() == tisch.getAnzahlPlaetze();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAnzahlPlaetze());
    }
}
