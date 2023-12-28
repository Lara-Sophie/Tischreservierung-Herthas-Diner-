package com.example.demo;

import java.util.LinkedList;
import java.util.Objects;

public class Kunden {

    LinkedList <Kunde> kunden;

    public LinkedList<Kunde> getKunden() {
        return kunden;
    }

    public void setKunden(LinkedList<Kunde> kunden) {
        this.kunden = kunden;
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
}
