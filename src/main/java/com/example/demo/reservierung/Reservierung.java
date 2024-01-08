package com.example.demo.reservierung;

import com.example.demo.kunde.Kunde;
import com.example.demo.tischReservierung.TischSlot;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table (name = "reservierungen")
public class Reservierung {

    @Id
    @Column (name = "reservierungid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservierungid;
    @Column (name = "personenanzahl")
    int personen;
    @Column (name = "startzeit")
    private LocalDateTime Startzeit;
    @Column (name = "endzeit")
    private LocalDateTime Endzeit;




    @ManyToOne
    @JoinColumn(name = "kundenid")
    private Kunde kunde;

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

    public int getPersonen() {
        return personen;
    }

    public void setPersonen(int personen) {
        this.personen = personen;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservierung that)) return false;
        return getId() == that.getId() && getPersonen() == that.getPersonen() && Objects.equals(getKunde(), that.getKunde())  && Objects.equals(getStartzeit(), that.getStartzeit()) && Objects.equals(getEndzeit(), that.getEndzeit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getKunde(), getStartzeit(), getEndzeit(), getPersonen());
    }
}
