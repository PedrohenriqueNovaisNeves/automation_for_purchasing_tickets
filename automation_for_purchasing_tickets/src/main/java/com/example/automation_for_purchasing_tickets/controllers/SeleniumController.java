package com.example.automation_for_purchasing_tickets.controllers;

import com.example.automation_for_purchasing_tickets.models.UserModel;
import com.example.automation_for_purchasing_tickets.services.SeleniumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/automation")
public class SeleniumController {

    @Autowired
    public final SeleniumService seleniumService;

    public SeleniumController(SeleniumService seleniumService){
        this.seleniumService = seleniumService;
    }


    @PostMapping("/startAutomation")
    public ResponseEntity<Object> automation(@Valid @RequestBody UserModel userModel) throws IOException {
        seleniumService.buyTicket(userModel.getCpfUser());
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }
}
