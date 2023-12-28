package com.example.demo;

import java.util.LinkedList;
import java.util.Objects;

public class Kunde {
    int id;
    String name;
    LinkedList <String> allergien;
    String email;
    String telefonnummer;
    LinkedList <Tischreservierung_herthas_diner> tischreservierung_herthas_diner;

    public Kunde(String name, String allergien, String email, String telefonnummer, LinkedList<Tischreservierung_herthas_diner> tischreservierung_herthas_diner) {
        this.id = id;
        this.name = name;
        this.tischreservierung_herthas_diner = tischreservierung_herthas_diner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<String> getAllergien() {
        return allergien;
    }

    public void setAllergien(LinkedList<String> allergien) {
        this.allergien = allergien;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kunde kunde)) return false;
        return id == kunde.id && Objects.equals(getName(), kunde.getName()) && Objects.equals(getAllergien(), kunde.getAllergien()) && Objects.equals(getEmail(), kunde.getEmail()) && Objects.equals(getTelefonnummer(), kunde.getTelefonnummer()) && Objects.equals(tischreservierung_herthas_diner, kunde.tischreservierung_herthas_diner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getAllergien(), getEmail(), getTelefonnummer(), tischreservierung_herthas_diner);
    }
}
