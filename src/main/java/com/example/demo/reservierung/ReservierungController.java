
    package com.example.demo.reservierung;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/reservierungen")
    public class ReservierungController {

        @Autowired
        private ReservierungService reservierungService;


        @PostMapping
        public ResponseEntity<Reservierung> createReservierung(@RequestBody ReservierungBody reservierungBody) {
            return ResponseEntity.ok(reservierungService.save(reservierungBody));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteReservierung(@PathVariable int id) {
            reservierungService.delete(id);
            return ResponseEntity.ok().build();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Reservierung> getReservierungenByKundenId(@PathVariable int id) {
            return ResponseEntity.ok(reservierungService.getAllByKundenID(id));
        }

        @GetMapping
        public ResponseEntity<List<Reservierung>> getAllReservierung() {return ResponseEntity.ok(reservierungService.getAll());}


    }






