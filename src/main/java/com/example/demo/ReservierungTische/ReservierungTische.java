package com.example.demo.ReservierungTische;

import com.example.demo.Reservierung.Reservierung;
import jakarta.persistence.*;
import com.example.demo.Tisch.Tisch;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "reservierungtische")
public class ReservierungTische {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ReservierungTischeID reservierungtischeID;


    @Column(name = "belegt")
    private boolean reserviert;


    @ManyToOne
    @JoinColumn(name = "tischid")
    private Tisch tisch;

    @ManyToOne
    @JoinColumn(name = "reservierungid")
    private Reservierung reservierung;

    public ReservierungTische() {
        // Default constructor required by JPA
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
        return reserviert == that.reserviert && Objects.equals(getReservierungtischeID(), that.getReservierungtischeID()) && Objects.equals(tisch, that.tisch) && Objects.equals(reservierung, that.reservierung);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReservierungtischeID(), reserviert, tisch, reservierung);
    }
}
