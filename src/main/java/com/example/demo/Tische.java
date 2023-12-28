package com.example.demo;

import java.util.LinkedList;
import java.util.Objects;

public class Tische {
    LinkedList <Tisch> tische;

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
}
