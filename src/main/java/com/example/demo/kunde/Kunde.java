package com.example.demo.kunde;

import com.example.demo.reservierung.Reservierung;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


@Entity
@Table (name = "kunden")
public class Kunde {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "name")
    private String name;
    @Column (name = "mail")
    private String email;

    @Column (name = "telefonnummer")
    private String telefonnummer;

    @Column (name = "allergien")
    private String allergien;

    @JsonIgnore
    @OneToMany(mappedBy = "kunde")
    private List<Reservierung> reservierung = new LinkedList<>();



    public Kunde() {
        // Default constructor required by JPA
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getAllergien() {
        return allergien;
    }

    public void setAllergien(String allergien) {
        this.allergien = allergien;
    }

    public List<Reservierung> getReservierung() {
        return reservierung;
    }

    public void setReservierung(List<Reservierung> reservierung) {
        this.reservierung = reservierung;
    }

    public void addReservierung(Reservierung reservierung) {
        this.reservierung.add(reservierung);
    }

    public void removeReservierung(Reservierung reservierung) {
        this.reservierung.remove(reservierung);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kunde kunde)) return false;
        return getId() == kunde.getId() && Objects.equals(getName(), kunde.getName()) && Objects.equals(getEmail(), kunde.getEmail()) && Objects.equals(getTelefonnummer(), kunde.getTelefonnummer()) && Objects.equals(getAllergien(), kunde.getAllergien()) && Objects.equals(getReservierung(), kunde.getReservierung()) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getTelefonnummer(), getAllergien(), getReservierung());
    }


}