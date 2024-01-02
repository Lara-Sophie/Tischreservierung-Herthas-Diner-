package com.example.demo.ReservierungTische;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReservierungTischeID implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tischid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservierungid;

    public ReservierungTischeID() {
    }
    public int getTischid() {
        return tischid;
    }

    public void setTischid(int tischid) {
        this.tischid = tischid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservierungTischeID that)) return false;
        return getTischid() == that.getTischid() && reservierungid == that.reservierungid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTischid(), reservierungid);
    }
}
