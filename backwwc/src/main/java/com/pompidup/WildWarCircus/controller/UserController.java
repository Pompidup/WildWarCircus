package com.pompidup.WildWarCircus.controller;

import com.pompidup.WildWarCircus.entities.User;
import com.pompidup.WildWarCircus.entities.UserDTO;
import com.pompidup.WildWarCircus.repositories.CircusRepository;
import com.pompidup.WildWarCircus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CircusRepository circusRepository;

    @GetMapping("/user/all")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public User createUser(@RequestBody UserDTO _user) throws Exception{
        User current = new User();
        current.setBot(_user.isBot());
        current.setPassword(_user.getPassword());
        current.setUsername(_user.getUsername());
        current.setBot(_user.isBot());
        current.setMoney(2500);
        if(_user.getCircusId() != null) {
            current.setCircus(circusRepository.findById(_user.getCircusId()).get());
        }
        return userRepository.save(current);

    }

    @GetMapping("/user")
    public UserDTO searchUser(@RequestParam(name="username") String username) {
        User userFound = userRepository.findByUsername(username);
        UserDTO userToReturn = new UserDTO();
        if (userFound.getCircus() != null) {
            userToReturn.setCircusId(userFound.getCircus().getId());
        }
        userToReturn.setBot(userFound.isBot());
        userToReturn.setMoney(userFound.getMoney());
        userToReturn.setPassword(userFound.getPassword());
        userToReturn.setPicture(userFound.getPicture());
        userToReturn.setUsername(userFound.getUsername());
        userToReturn.setId(userFound.getId());

        return userToReturn;
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return true;
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserDTO user) {
        User userToUpdate = userRepository.findById(id).get();
        if (user.getUsername() != null) {
            userToUpdate.setUsername(user.getUsername());
        }
        if (user.getPassword() != null) {
            userToUpdate.setPassword(user.getPassword());
        }
        if (user.getMoney() != null) {
            userToUpdate.setMoney(user.getMoney());
        } else {
            userToUpdate.setMoney(2500);
        }
        if (user.getPicture() != null) {
            userToUpdate.setPicture(user.getPicture());
        }
        if (user.getCircusId() != null) {
            userToUpdate.setCircus(circusRepository.findById(user.getCircusId()).get());
        }
        if (user.isBot() != null) {
            userToUpdate.setBot(user.isBot());
        }
        return userRepository.save(userToUpdate);
    }
}
