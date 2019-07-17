package com.pompidup.WildWarCircus.controller;

import com.pompidup.WildWarCircus.entities.Stand;
import com.pompidup.WildWarCircus.entities.StandDTO;
import com.pompidup.WildWarCircus.repositories.CircusRepository;
import com.pompidup.WildWarCircus.repositories.StandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StandController {

    @Autowired
    private StandRepository standRepository;
    @Autowired
    private CircusRepository circusRepository;

    @GetMapping("/stand/all")
    public List<Stand> getAllStand() {
        return standRepository.findAll();
    }

    @PostMapping("/stand")
    public Stand createStand(@RequestBody StandDTO _stand) throws Exception{
        Stand current = new Stand();
        if (_stand.getCircusId() != null) {
            current.setCircus(circusRepository.findById(_stand.getCircusId()).get());
        }
        current.setConvertion(_stand.getConvertion());
        current.setCost(_stand.getCost());
        current.setGain(_stand.getGain());
        current.setDescription(_stand.getDescription());
        current.setMaintenance(_stand.getMaintenance());
        current.setName(_stand.getName());
        current.setPicture(_stand.getPicture());

        return standRepository.save(current);
    }

    @DeleteMapping("stand/{id}")
    public boolean deleteStand(@PathVariable long id) {
        standRepository.deleteById(id);
        return true;
    }
}
