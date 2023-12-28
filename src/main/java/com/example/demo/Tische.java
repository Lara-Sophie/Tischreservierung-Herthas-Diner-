package com.example.demo;

import java.util.LinkedList;
import java.util.Objects;

public class Tische {
    LinkedList<Tisch> tische;

    public Tische() {
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

    // Add-Methode: Füge einen Tisch an einem freien Platz hinzu
    public void addTisch(Tisch tisch) {

            // Überprüfe, ob die ID bereits vorhanden ist
            boolean idAlreadyExists = tische.stream().anyMatch(existingTisch -> existingTisch.getId() == tisch.getId());

            if (!idAlreadyExists) {
                // Finde den ersten freien Platz in der Liste
                int freeIndex = 0;
                while (freeIndex < tische.size() && tische.get(freeIndex) != null) {
                    freeIndex++;
                }

                // Füge den Tisch an der gefundenen Position hinzu
                if (freeIndex < tische.size()) {
                    tische.set(freeIndex, tisch);
                } else {
                    tische.add(tisch); // Füge den Tisch am Ende der Liste hinzu, falls alle Plätze belegt sind
                }
            } else {
                System.out.println("Ein Tisch mit dieser ID existiert bereits.");
            }

    }

    // Delete-Methode: Lösche einen Tisch
    public void deleteTisch(Tisch tisch){
        if (tische != null) {
            tische.remove(tisch);
        }
    }
}