package com.example.demo;

import jakarta.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;




@Entity
public class Tischreservierung_herthas_diner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "tischreservierung", cascade = CascadeType.ALL)
    public LinkedList <Tisch> tische;
    private Date zeit;
    private Date datum;
    private int personen;

    public Tischreservierung_herthas_diner() {


    }




    public Date getZeit() {return zeit;}

    public void setZeit(Date zeit) {this.zeit = zeit;}

    public Date getDatum() {return datum;}

    public void setDatum(Date datum) {this.datum = datum;}

    public int getPersonen() {return personen;}

    public void setPersonen(int personen) {this.personen = personen;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tischreservierung_herthas_diner that)) return false;
        return getId() == that.getId() && getPersonen() == that.getPersonen() && Objects.equals(getZeit(), that.getZeit()) && Objects.equals(getDatum(), that.getDatum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getZeit(), getDatum(), getPersonen());
    }
}
