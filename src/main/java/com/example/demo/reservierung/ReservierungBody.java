package com.example.demo.reservierung;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

public class ReservierungBody {
    @JsonProperty("kundenId")
    private Integer kundenId;

    @JsonProperty("tischSlotId")
    private Integer tischSlotIds;

    @JsonProperty("startZeit")
    private LocalDateTime startZeit;

    @JsonProperty("endZeit")
    private LocalDateTime endZeit;

    @JsonProperty("personen")
    private int personen;


    public ReservierungBody() {
    }

    public Integer getKundenId() {
        return kundenId;
    }

    public void setKundenId(Integer kundenId) {
        this.kundenId = kundenId;
    }

    public Integer getTischSlotIds() {
        return tischSlotIds;
    }

    public void setTischSlotIds(Integer tischSlotIds) {
        this.tischSlotIds = tischSlotIds;
    }

    public LocalDateTime getStartZeit() {
        return startZeit;
    }

    public void setStartZeit(LocalDateTime startZeit) {
        this.startZeit = startZeit;
    }

    public LocalDateTime getEndZeit() {
        return endZeit;
    }

    public void setEndZeit(LocalDateTime endZeit) {
        this.endZeit = endZeit;
    }

    public int getPersonen() {
        return personen;
    }

    public void setPersonen(int personen) {
        this.personen = personen;
    }
}
