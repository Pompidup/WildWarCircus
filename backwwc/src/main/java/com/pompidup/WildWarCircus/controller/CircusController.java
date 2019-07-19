package com.pompidup.WildWarCircus.controller;

import com.pompidup.WildWarCircus.entities.Circus;
import com.pompidup.WildWarCircus.repositories.CircusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CircusController {

    @Autowired
    CircusRepository circusRepository;

    @GetMapping("/circus/all")
    public List<Circus> allCircus() {
        return circusRepository.findAll();
    }

    @GetMapping("/circus/{id}")
    public Circus getCircusById(@PathVariable long id) {
        return circusRepository.findById(id).get();
    }

    @PostMapping("circus")
    public Circus createCircus(@RequestBody Circus circus) {
        return circusRepository.save(circus);
    }

    @DeleteMapping("/circus/{id}")
    public boolean deleteCircus(@PathVariable long id) {
        circusRepository.deleteById(id);
        return true;
    }

    @PutMapping("/circus/{id}")
    public Circus updateCircus(@PathVariable long id, @RequestBody Circus circus) {
        Circus circusToUpdate = circusRepository.findById(id).get();
        if(circus.getCapacity() != null) {
            circusToUpdate.setCapacity(circus.getCapacity());
        }
        if(circus.getCost() != null) {
            circusToUpdate.setCost(circus.getCost());
        }
        if(circus.getLevel() != null) {
            circusToUpdate.setLevel(circus.getLevel());
        }
        if(circus.getNbShow() != null) {
            circusToUpdate.setNbShow(circus.getNbShow());
        }
        if(circus.getNbStand() != null) {
            circusToUpdate.setNbStand(circus.getNbStand());
        }
        if(circus.getPrice() != null) {
            circusToUpdate.setPrice(circus.getPrice());
        }
        if(circus.getPopularity() != null) {
            circusToUpdate.setPopularity(circus.getPopularity());
        }
        if(circus.getNbShowMax() != null) {
            circusToUpdate.setNbShowMax(circus.getNbShowMax());
        }
        if(circus.getNbStandMax() != null) {
            circusToUpdate.setNbStandMax(circus.getNbStandMax());
        }
        if(circus.getPicture() != null) {
            circusToUpdate.setPicture(circus.getPicture());
        }
        return circusRepository.save(circusToUpdate);
    }
}
