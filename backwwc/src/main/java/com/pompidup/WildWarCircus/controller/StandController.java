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

    @PutMapping("/stand/{id}")
    public Stand updateStand(@PathVariable Long id, @RequestBody StandDTO stand) {
        Stand standToUpdate = standRepository.findById(id).get();
        if(stand.getConvertion() != null) { standToUpdate.setConvertion(stand.getConvertion()); }
        if(stand.getName() != null) { standToUpdate.setName(stand.getName()); }
        if(stand.getGain() != null) { standToUpdate.setGain(stand.getGain()); }
        if(stand.getCost() != null) { standToUpdate.setCost(stand.getCost()); }
        if(stand.getMaintenance() != null) { standToUpdate.setMaintenance(stand.getMaintenance()); }
        if(stand.getDescription() != null) { standToUpdate.setDescription(stand.getDescription()); }
        if(stand.getPicture() != null) { standToUpdate.setPicture(stand.getPicture()); }
        if(stand.getCircusId() != null) {
            standToUpdate.setCircus(circusRepository.findById(stand.getCircusId()).get());
        }
            return standRepository.save(standToUpdate);
        }

    @DeleteMapping("stand/{id}")
    public boolean deleteStand(@PathVariable Long id) {
        standRepository.deleteById(id);
        return true;
    }
}
