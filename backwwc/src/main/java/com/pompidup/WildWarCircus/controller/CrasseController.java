package com.pompidup.WildWarCircus.controller;

import com.pompidup.WildWarCircus.entities.Crasse;
import com.pompidup.WildWarCircus.entities.CrasseDTO;
import com.pompidup.WildWarCircus.repositories.CircusRepository;
import com.pompidup.WildWarCircus.repositories.CrasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CrasseController {

    @Autowired
    private CrasseRepository crasseRepository;
    @Autowired
    private CircusRepository circusRepository;

    @GetMapping("/crasse/all")
    public List<Crasse> allCrasse() {
        return crasseRepository.findAll();
    }

    @PostMapping("/crasse")
    public Crasse createCrasse(@RequestBody CrasseDTO _crasse) throws Exception{
        Crasse current = new Crasse();
        current.setCost(_crasse.getCost());
        current.setDescription(_crasse.getDescription());
        current.setMissTurn(_crasse.getMissTurn());
        current.setName(_crasse.getName());
        current.setPicture(_crasse.getPicture());
        current.setPopDown(_crasse.getPopDown());
        current.setCircus(circusRepository.findById(_crasse.getCircusId()).get());

        return crasseRepository.save(current);
    }

    @DeleteMapping("crasse/{id}")
    public boolean deleteCrasse(@PathVariable long id) {
        crasseRepository.deleteById(id);
        return true;
    }
}
