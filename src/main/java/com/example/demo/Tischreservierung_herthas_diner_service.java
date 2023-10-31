package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Tischreservierung_herthas_diner_service {


    @Autowired
    Tischreservierung_herthas_diner_Repository repo;

    public Tischreservierung_herthas_diner save(Tischreservierung_herthas_diner thing) {
        return repo.save(thing);
    }

    public Tischreservierung_herthas_diner get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Tischreservierung_herthas_diner> getAll() {
        Iterable<Tischreservierung_herthas_diner> iterator = repo.findAll();
        List<Tischreservierung_herthas_diner> things = new ArrayList<Tischreservierung_herthas_diner>();
        for (Tischreservierung_herthas_diner thing : iterator) things.add(thing);
        return things;
    }
}
