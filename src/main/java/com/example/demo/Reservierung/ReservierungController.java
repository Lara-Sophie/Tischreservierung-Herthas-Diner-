
    package com.example.demo.Reservierung;

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

        @PostMapping
        public ResponseEntity<Reservierung> createReservierung(@RequestBody Reservierung reservierung) {
            return ResponseEntity.ok(reservierungService.save(reservierung));
        }

        @PostMapping
        public ResponseEntity<Reservierung> createReservierung(@RequestParam Long kundenId, @RequestParam List<Long> tischIds, @RequestParam LocalDateTime startZeit, @RequestParam LocalDateTime endZeit ){
            Reservierung reservierung = reservierungService.createReservierung(kundenId, tischIds, startZeit, endZeit);
            return ResponseEntity.ok(reservierung);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteReservierung(@PathVariable int id) {
            reservierungService.delete(id);
            return ResponseEntity.ok().build();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Reservierung> getReservierung(@PathVariable int id) {
            return ResponseEntity.ok(reservierungService.get(id));
        }

        @GetMapping
        public ResponseEntity<List<Reservierung>> getAllReservierungen() {
            return ResponseEntity.ok(reservierungService.getAll());
        }


    }






