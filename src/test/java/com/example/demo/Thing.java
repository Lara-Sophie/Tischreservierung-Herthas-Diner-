package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Thing {
    public Thing (){}

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;


    public Thing (String name, int price){
        this.name=name;
        this.price=price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
