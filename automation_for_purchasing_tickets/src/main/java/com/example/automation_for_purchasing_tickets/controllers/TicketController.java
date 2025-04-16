package com.example.automation_for_purchasing_tickets.controllers;

import com.example.automation_for_purchasing_tickets.dtos.TicketRecord;
import com.example.automation_for_purchasing_tickets.models.TicketsModel;
import com.example.automation_for_purchasing_tickets.services.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/ping")
    public String ping(){
        return "ping!!";
    }

    @PostMapping("/saveTicket")
    public ResponseEntity<Object> saveTicket(@Valid @RequestBody TicketRecord ticketRecord){
        ticketService.saveTicket(ticketRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ticket registered with successfully");
    }

}
