
    package com.example.demo.Reservierung;

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
        public ResponseEntity<Reservierung> createReservierung(@RequestBody Reservierung reservierung) {
            return ResponseEntity.ok(reservierungService.save(reservierung));
        }

        @GetMapping("/{id}")
        public ResponseEntity<Reservierung> getReservierung(@PathVariable int id) {
            return ResponseEntity.ok(reservierungService.get(id));
        }

        @GetMapping
        public ResponseEntity<List<Reservierung>> getAllReservierungen() {
            return ResponseEntity.ok(reservierungService.getAll());
        }

        // Weitere Methoden nach Bedarf
    }






