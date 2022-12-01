package com.andygomez.main.controller;

import com.andygomez.main.dto.UserDTO;
import com.andygomez.main.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {



    private final UserService service;


    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody UserDTO user){
        service.saveUser(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable ("id") Integer id, @RequestBody UserDTO user){
        service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable ("id") Integer id){
        service.deleteUser(id);
    }

}
