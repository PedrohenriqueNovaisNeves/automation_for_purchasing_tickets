package com.example.automation_for_purchasing_tickets.controllers;

import com.example.automation_for_purchasing_tickets.dtos.UserRecord;
import com.example.automation_for_purchasing_tickets.models.UserModel;
import com.example.automation_for_purchasing_tickets.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/ping")
    public String ping(){
        return "ping";
    }

    @PostMapping("/saveUser")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody UserRecord userRecord){
        userService.saveUser(userRecord);

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered with successfully");
    }

    @GetMapping("/listAllUsers")
    public ResponseEntity<List<UserModel>> listUsers(){
        List<UserModel> listUsers= userService.listAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(listUsers);
    }
}
