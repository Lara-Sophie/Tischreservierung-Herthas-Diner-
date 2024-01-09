package com.example.demo.tischReservierung;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class TischSlotBody {

    @JsonProperty("tischId")
    private int tischId;

    @JsonProperty("startzeit")
    private String Startzeit;



    public TischSlotBody() {
    }

    public Integer getTischId() {
        return tischId;
    }

    public void setTischId(int tischId) {
        this.tischId = tischId;
    }

    public String getStartzeit() {
        return Startzeit;
    }

    public void setStartzeit(String startzeit) {
        Startzeit = startzeit;
    }



}
