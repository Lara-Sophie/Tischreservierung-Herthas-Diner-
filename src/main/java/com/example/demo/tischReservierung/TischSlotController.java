package com.example.demo.tischReservierung;


import com.example.demo.tisch.Tisch;
import com.example.demo.tisch.TischService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TischSlotController {

    @Autowired
    private TischSlotService tischSlotService;
    @PostMapping
    public ResponseEntity<TischSlot> createTischSlot(@RequestBody TischSlotBody tischSlotBody) {
        return ResponseEntity.ok(tischSlotService.save(tischSlotBody));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTischSlot(@PathVariable int id) {
        tischSlotService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TischSlot> getTischSlot(@PathVariable int id) {
        return ResponseEntity.ok(tischSlotService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<TischSlot>> getAllTischSlots() {
        return ResponseEntity.ok(tischSlotService.getAll());
    }
}

