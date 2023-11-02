package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class Tischreservierung_herthas_diner_Controller {

    @Autowired
     Tischreservierung_herthas_diner_service service;

    Logger logger = LoggerFactory.getLogger(Tischreservierung_herthas_diner_Controller.class);

    @PostMapping("/reservierung")
    public Tischreservierung_herthas_diner createTischreservierung_herthas_diner(@RequestBody Tischreservierung_herthas_diner reservierung) {
        return service.save(reservierung);
    }

    @GetMapping("/reservierung/{id}")
    public Tischreservierung_herthas_diner getTischreservierung_herthas_diner(@PathVariable String id) {
        logger.info("GET request on route reservierung with {}", id);
        Long reservierungId = Long.parseLong(id);
        return service.get(reservierungId);
    }

    @GetMapping("/reservierung")
    public List<Tischreservierung_herthas_diner> getAllTischreservierung_herthas_diner() {
        return service.getAll();
    }




}
