package com.example.demo.reservierung;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

public class ReservierungBody {
    @JsonProperty("kundenId")
    private Integer kundenId;

    @JsonProperty("tischSlotId")
    private Integer tischSlotId;




    public ReservierungBody() {
    }

    public Integer getKundenId() {
        return kundenId;
    }

    public void setKundenId(Integer kundenId) {
        this.kundenId = kundenId;
    }

    public Integer getTischSlotId() {
        return tischSlotId;
    }

    public void setTischSlotId(Integer tischSlotIds) {
        this.tischSlotId = tischSlotIds;
    }

}
