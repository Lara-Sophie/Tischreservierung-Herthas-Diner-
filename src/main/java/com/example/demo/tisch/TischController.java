package com.example.demo.tisch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tische")
public class TischController {

    @Autowired
    private TischService tischService;

    @PostMapping
    public ResponseEntity<Tisch> createTisch(@RequestBody Tisch tisch) {
        return ResponseEntity.ok(tischService.save(tisch));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTisch(@PathVariable int id) {
        tischService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tisch> getTisch(@PathVariable int id) {
        return ResponseEntity.ok(tischService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<Tisch>> getAllTische() {
        return ResponseEntity.ok(tischService.getAll());
    }
}
