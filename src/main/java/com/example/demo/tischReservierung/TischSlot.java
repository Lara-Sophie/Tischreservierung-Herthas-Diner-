package com.example.demo.tischReservierung;

import com.example.demo.reservierung.Reservierung;
import com.example.demo.tisch.Tisch;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "tischSlot")
public class TischSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tischslotid;

    @Column (name = "startzeit")
    private LocalDateTime Startzeit;
    @Column (name = "endzeit")
    private LocalDateTime Endzeit;



    @OneToOne(mappedBy = "tischSlot")
    private Reservierung reservierung;

    @ManyToOne
    @JoinColumn(name = "tischid", nullable = false)
    private Tisch tisch;

    public TischSlot() {
    }

    public LocalDateTime getStartzeit() {
        return Startzeit;
    }

    public void setStartzeit(LocalDateTime startzeit) {
        Startzeit = startzeit;
    }

    public LocalDateTime getEndzeit() {
        return Endzeit;
    }

    public void setEndzeit(LocalDateTime endzeit) {
        Endzeit = endzeit;
    }



    public Reservierung getReservierung() {
        return reservierung;
    }

    public void setReservierung(Reservierung reservierung) {
        this.reservierung = reservierung;
    }

    public Tisch getTisch() {
        return tisch;
    }

    public void setTisch(Tisch tisch) {
        this.tisch = tisch;
    }
}
