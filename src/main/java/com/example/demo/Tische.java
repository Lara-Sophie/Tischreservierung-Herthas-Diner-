package com.example.demo;

import java.util.LinkedList;
import java.util.Objects;

public class Tische {
    LinkedList<Tisch> tische;

    public Tische(LinkedList<Tisch> tische) {
        this.tische = tische;
    }

    public LinkedList<Tisch> getTische() {
        return tische;
    }

    public void setTische(LinkedList<Tisch> tische) {
        this.tische = tische;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tische tische1)) return false;
        return Objects.equals(getTische(), tische1.getTische());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTische());
    }

    // Add-Methode: Füge einen Tisch hinzu
    public void addTisch(int anzahlPlaetze, boolean reserviert) {
        // Find the first free slot in the list
        int freeIndex = 0;
        while (freeIndex < tische.size() && tische.get(freeIndex) != null) {
            freeIndex++;
            System.out.println("freeIndex: " + freeIndex);
        }
        System.out.println("Ahh  " + freeIndex + " behh " + tische.size());
        // Add the new Tisch to the list
        tische.add(freeIndex, new Tisch(freeIndex, anzahlPlaetze, reserviert));
    }


    // Delete-Methode: Lösche einen Tisch
    public void deleteTisch(Tisch tisch){
        if (tische != null) {
            tische.remove(tisch);
        }
    }
}