package com.example.demo.Reservierung;

import com.example.demo.Kunde.Kunde;
import com.example.demo.Tisch.Tisch;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "reservierungen")
public class Reservierung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "personenanzahl")
    int personen;
    @Column (name = "startzeit")
    private LocalDateTime Startzeit;
    @Column (name = "endzeit")
    private LocalDateTime Endzeit;



    @ManyToOne
    @JoinColumn(name = "kundenid")
    private Kunde kunde;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "reservierungtische",
            joinColumns = @JoinColumn(name = "reservierungid"),
            inverseJoinColumns = @JoinColumn(name = "tischid")
    )
    private List<Tisch> tische;


    public Reservierung() {
        // Default constructor required by JPA
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public List<Tisch> getTische() {
        return tische;
    }

    public void setTische(List<Tisch> tische) {
        this.tische = tische;
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
        return getId() == that.getId() && getPersonen() == that.getPersonen() && Objects.equals(getKunde(), that.getKunde()) && Objects.equals(getTische(), that.getTische()) && Objects.equals(getStartzeit(), that.getStartzeit()) && Objects.equals(getEndzeit(), that.getEndzeit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getKunde(), getTische(), getStartzeit(), getEndzeit(), getPersonen());
    }
}
