package com.example.demo.tischReservierung;

import com.example.demo.reservierung.Reservierung;
import com.example.demo.tisch.Tisch;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "tisch_slot")
public class TischSlot {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tischslotid;



    @Column (name = "startzeit")
    private LocalDateTime Startzeit;
    @Column (name = "endzeit")
    private LocalDateTime Endzeit;

    @Column (name = "reserviert")
    private boolean reserviert;


    @JsonIgnore
    @OneToOne(mappedBy = "tischSlot")
    private Reservierung reservierung;

    @JsonIgnore
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

    public boolean isReserviert() {
        return reserviert;
    }

    public void setReserviert(boolean reserviert) {
        this.reserviert = reserviert;
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

    public Integer getTischslotid() {
        return tischslotid;
    }

    public void setTischslotid(Integer tischslotid) {
        this.tischslotid = tischslotid;
    }
}
