package com.example.automation_for_purchasing_tickets.controllers;

import com.example.automation_for_purchasing_tickets.dtos.UserRecord;
import com.example.automation_for_purchasing_tickets.models.UserModel;
import com.example.automation_for_purchasing_tickets.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/listOneUser/{id}")
    public ResponseEntity<Object> listOneUser(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.listOneUser(id));
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id")UUID id, @Valid @RequestBody UserRecord userRecord){
        var user = new UserModel();
        BeanUtils.copyProperties(userRecord, user);

        userService.updateUser(id, user);

        return ResponseEntity.status(HttpStatus.OK).body("User updated with successfully");
    }

    @PutMapping("/updatePasswordUser/{id}")
    public ResponseEntity<Object> updatePasswordUser(@PathVariable(value = "id")UUID id, @Valid @RequestBody UserModel userModel){
        userService.updatePasswordtheUser(id, userModel.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body("Password the user updating with successfully");
    }


}
