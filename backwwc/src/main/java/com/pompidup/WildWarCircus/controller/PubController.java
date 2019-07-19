package com.pompidup.WildWarCircus.controller;

import com.pompidup.WildWarCircus.entities.Pub;
import com.pompidup.WildWarCircus.entities.PubDTO;
import com.pompidup.WildWarCircus.repositories.CircusRepository;
import com.pompidup.WildWarCircus.repositories.PubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PubController {

    @Autowired
    private PubRepository pubRepository;
    @Autowired
    private CircusRepository circusRepository;

    @GetMapping("/pub/all")
    public List<Pub> allPub() {
        return pubRepository.findAll();
    }

    @PostMapping("/pub")
    public Pub createPub(@RequestBody PubDTO _pub) throws Exception{
        Pub current = new Pub();
        current.setName(_pub.getName());
        current.setDescription(_pub.getDescription());
        current.setCost(_pub.getCost());
        current.setPicture(_pub.getPicture());
        current.setPopUp(_pub.getPopUp());
        if(_pub.getCircusId() != null) {
            current.setCircus(circusRepository.findById(_pub.getCircusId()).get());
        }
        return  pubRepository.save(current);
    }

    @PutMapping("pub/{id}")
    public Pub updatePub(@PathVariable Long id, @RequestBody PubDTO pub) {
        Pub pubToUpdate = pubRepository.findById(id).get();
        if(pub.getName() != null) {pubToUpdate.setName(pub.getName());}
        if(pub.getCost() != null) {pubToUpdate.setCost(pub.getCost());}
        if(pub.getPopUp() != null) {pubToUpdate.setPopUp(pub.getPopUp());}
        if(pub.getDescription() != null) {pubToUpdate.setDescription(pub.getDescription());}
        if(pub.getPicture() != null) {pubToUpdate.setPicture(pub.getPicture());}
        if(pub.getCircusId() != null) {pubToUpdate.setCircus(circusRepository.findById(pub.getCircusId()).get());}

        return pubRepository.save(pubToUpdate);
    }

    @DeleteMapping("pub/{id}")
    public boolean deletePub(@PathVariable Long id) {
        pubRepository.deleteById(id);
        return true;
    }

}
