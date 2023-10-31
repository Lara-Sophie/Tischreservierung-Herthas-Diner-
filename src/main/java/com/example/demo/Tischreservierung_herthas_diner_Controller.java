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

    @PostMapping("/things")
    public Tischreservierung_herthas_diner createThing(@RequestBody Tischreservierung_herthas_diner thing) {
        return service.save(thing);
    }

    @GetMapping("/things/{id}")
    public Tischreservierung_herthas_diner getThing(@PathVariable String id) {
        logger.info("GET request on route things with {}", id);
        Long thingId = Long.parseLong(id);
        return service.get(thingId);
    }

    @GetMapping("/things")
    public List<Tischreservierung_herthas_diner> getAllThings() {
        return service.getAll();
    }


}
