
    package com.example.demo.reservierung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

    @RestController
    @RequestMapping("/reservierungen")
    public class ReservierungController {

        @Autowired
        private ReservierungService reservierungService;



    /*    @PostMapping
        public ResponseEntity<Reservierung> createReservierung(@RequestBody ReservierungBody reservierungBody) throws InvalidReservationTimeException, TableNotAvailableException {
            Reservierung reservierung = reservierungService.createReservierung(reservierungBody);
            return ResponseEntity.ok(reservierung);
        }*/




    }






