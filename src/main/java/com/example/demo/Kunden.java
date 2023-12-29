package com.example.demo;

import java.util.LinkedList;
import java.util.Objects;

public class Kunden {

    LinkedList <Kunde> kunden;



    public Kunden(LinkedList<Kunde> kunden) {
        this.kunden = kunden;
    }
    public LinkedList<Kunde> getKunden() {
        return kunden;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kunden kunden1)) return false;
        return Objects.equals(getKunden(), kunden1.getKunden());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKunden());
    }

    // Add-Methode: Füge einen Tisch hinzu
    public void addKunde(String name, String eMail, String telefonnummer,LinkedList<Tischreservierung_herthas_diner> tischreservierung_herthas_diner) {
        // Find the first free slot in the list
        int freeIndex = 0;
        while (freeIndex < kunden.size() && kunden.get(freeIndex) != null) {
            freeIndex++;
        }

        // Add the new Tisch to the list
        kunden.add(freeIndex, new Kunde(freeIndex,name, eMail, telefonnummer, tischreservierung_herthas_diner));
    }


    // Delete-Methode: Lösche einen Tisch
    public void deleteKunde(Kunde kunde){
        if (kunden != null) {
            kunden.remove(kunde);
        }
    }
}
