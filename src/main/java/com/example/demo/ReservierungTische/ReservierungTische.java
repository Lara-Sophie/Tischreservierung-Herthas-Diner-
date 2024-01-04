package com.example.demo.ReservierungTische;

import com.example.demo.Reservierung.Reservierung;
import jakarta.persistence.*;
import com.example.demo.Tisch.Tisch;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "reservierungtische")
public class ReservierungTische {

    @EmbeddedId
    private ReservierungTischeID reservierungtischeID;


    @Column(name = "belegt")
    private boolean reserviert;


    @ManyToOne
    private Tisch tisch;

    @ManyToOne
    private Reservierung reservierung;

    public ReservierungTische() {
        // Default constructor required by JPA
    }

    public ReservierungTische(Reservierung reservierung, Tisch tisch, boolean b) {
    }



    public boolean isReserviert() {
        return reserviert;
    }

    public void setReserviert(boolean reserviert) {
        this.reserviert = reserviert;
    }

    public Tisch getTisch() {
        return tisch;
    }

    public void setTisch(Tisch tisch) {
        this.tisch = tisch;
    }

    public Reservierung getReservierung() {
        return reservierung;
    }

    public void setReservierung(Reservierung reservierung) {
        this.reservierung = reservierung;
     }

    public ReservierungTischeID getReservierungtischeID() {
        return reservierungtischeID;
    }

    public void setReservierungtischeID(ReservierungTischeID reservierungtischeID) {
        this.reservierungtischeID = reservierungtischeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservierungTische that)) return false;
        return reserviert == that.reserviert && Objects.equals(getReservierungtischeID(), that.getReservierungtischeID()) && Objects.equals(tisch, that.tisch) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReservierungtischeID(), reserviert, tisch);
    }
}
