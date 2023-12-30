package com.example.demo.Tisch;



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
