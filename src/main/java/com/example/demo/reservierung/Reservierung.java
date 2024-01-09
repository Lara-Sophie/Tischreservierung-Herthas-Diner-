package com.example.demo.reservierung;

import com.example.demo.kunde.Kunde;
import com.example.demo.tischReservierung.TischSlot;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table (name = "reservierungen")
public class Reservierung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservierungid;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "kundenid")
    private Kunde kunde;


    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tischslotid", referencedColumnName = "tischslotid")
    private TischSlot tischSlot;



    public Reservierung() {
        // Default constructor required by JPA
    }


    public int getId() {
        return reservierungid;
    }

    public void setId(int id) {
        this.reservierungid = id;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public TischSlot getTischSlot() {
        return tischSlot;
    }

    public void setTischSlot(TischSlot tischSlot) {
        this.tischSlot = tischSlot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservierung that)) return false;
        return getId() == that.getId()  && Objects.equals(getKunde(), that.getKunde());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getKunde());
    }
}
