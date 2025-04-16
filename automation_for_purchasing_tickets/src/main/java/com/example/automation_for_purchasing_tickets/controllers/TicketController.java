package com.example.automation_for_purchasing_tickets.controllers;

import com.example.automation_for_purchasing_tickets.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/ping")
    public String ping(){
        return "ping!!";
    }


}
