package com.example.demo.ReservierungTische;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReservierungTischeID implements Serializable {
    private Integer tischid;
    private Integer reservierungid;

    public ReservierungTischeID() {
    }

    public Integer getTischid() {
        return tischid;
    }

    public void setTischid(Integer tischid) {
        this.tischid = tischid;
    }

    public Integer getReservierungid() {
        return reservierungid;
    }

    public void setReservierungid(Integer reservierungid) {
        this.reservierungid = reservierungid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservierungTischeID)) return false;
        ReservierungTischeID that = (ReservierungTischeID) o;
        return Objects.equals(tischid, that.tischid) && Objects.equals(reservierungid, that.reservierungid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tischid, reservierungid);
    }


}
