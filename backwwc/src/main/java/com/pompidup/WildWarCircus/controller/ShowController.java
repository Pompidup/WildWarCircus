package com.pompidup.WildWarCircus.controller;

import com.pompidup.WildWarCircus.entities.Shoow;
import com.pompidup.WildWarCircus.entities.ShoowDTO;
import com.pompidup.WildWarCircus.repositories.CircusRepository;
import com.pompidup.WildWarCircus.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ShowController {

    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private CircusRepository circusRepository;

    @GetMapping("/show/all")
    public List<Shoow> allShow() {
        return showRepository.findAll();
    }

    @PostMapping("/show")
    public Shoow createShow(@RequestBody ShoowDTO _show) throws Exception {
        Shoow current = new Shoow();
        current.setCost(_show.getCost());
        current.setName(_show.getName());
        current.setDescription(_show.getDescription());
        current.setPicture(_show.getPicture());
        current.setPopUp(_show.getPopUp());
        current.setType(_show.getType());
        current.setCircus(circusRepository.findById(_show.getCircusId()).get());

        return showRepository.save(current);
    }

    @DeleteMapping("show/{id}")
    public boolean deleteShow(@PathVariable long id) {
        showRepository.deleteById(id);
        return true;
    }
}
