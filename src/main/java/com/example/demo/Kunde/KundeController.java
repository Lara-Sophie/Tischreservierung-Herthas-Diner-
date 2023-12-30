package com.example.demo.Kunde;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kunden")
public class KundeController {

    @Autowired
    private KundeService kundeService;

    @PostMapping
    public ResponseEntity<Kunde> createKunde(@RequestBody Kunde kunde) {
        return ResponseEntity.ok(kundeService.save(kunde));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKunde(@PathVariable int id) {
        kundeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kunde> getKunde(@PathVariable int id) {
        return ResponseEntity.ok(kundeService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<Kunde>> getAllKunden() {
        return ResponseEntity.ok(kundeService.getAll());
    }
}
