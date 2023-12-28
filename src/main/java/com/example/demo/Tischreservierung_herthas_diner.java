package com.example.demo;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
public class Tischreservierung_herthas_diner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int tischnummer;
    private Date zeit;
    private Date datum;
    private int personen;


    public Tischreservierung_herthas_diner(int tischnummer, int id, Date zeit, Date datum) {
        this.tischnummer = tischnummer;
        this.id = id;
        this.zeit = zeit;
        this.datum = datum;
    }


    public int getTischnummer() {return tischnummer;}

    public void setTischnummer(int tischnummer) {this.tischnummer = tischnummer;}

    public Date getZeit() {return zeit;}

    public void setZeit(Date zeit) {this.zeit = zeit;}

    public Date getDatum() {return datum;}

    public void setDatum(Date datum) {this.datum = datum;}

    public int getPersonen() {return personen;}

    public void setPersonen(int personen) {this.personen = personen;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Tischreservierung_herthas_diner that = (Tischreservierung_herthas_diner) object;
        return id == that.id && tischnummer == that.tischnummer && personen == that.personen && java.util.Objects.equals(zeit, that.zeit) && java.util.Objects.equals(datum, that.datum);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id, tischnummer, zeit, datum, personen);
    }

    @Override
    public String toString() {
        return "Tischreservierung_herthas_diner{" +
                "id=" + id +
                ", Tischnummer='" + tischnummer + '\'' +
                ", Zeit='" + zeit + '\'' +
                ", Datum='" + datum + '\'' +
                ", Personen=" + personen +
                '}';
    }
}
