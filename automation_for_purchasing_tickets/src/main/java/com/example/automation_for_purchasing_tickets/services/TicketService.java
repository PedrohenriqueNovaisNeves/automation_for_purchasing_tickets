package com.example.automation_for_purchasing_tickets.services;

import com.example.automation_for_purchasing_tickets.dtos.TicketRecord;
import com.example.automation_for_purchasing_tickets.models.TicketsModel;
import com.example.automation_for_purchasing_tickets.repositorys.TicketRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    public TicketsModel saveTicket(TicketRecord ticketRecord){
        var ticket = new TicketsModel();
        BeanUtils.copyProperties(ticketRecord, ticket);

        return ticketRepository.save(ticket);
    }

    public List<TicketsModel> listAllTickets(){
        return ticketRepository.findAll();
    }

    public Object listOneTicket(UUID id){
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public Object updateTicket(UUID id, TicketsModel ticketModel){
        Optional<TicketsModel> ticket = ticketRepository.findById(id);

        if(ticket.isEmpty()){
            throw new RuntimeException("Ticket not found");
        }

        var newTicket = ticket.get();

        newTicket.setNameTicket(ticketModel.getNameTicket());
        newTicket.setSector(ticketModel.getSector());
        newTicket.setGame(ticketModel.getGame());
        newTicket.setDateOfGame(ticketModel.getDateOfGame());

        return ticketRepository.save(newTicket);
    }

    public void deleteOneTicket(UUID id){
        Optional<TicketsModel> ticket = ticketRepository.findById(id);

        if(ticket.isEmpty()){
            new RuntimeException("ticket not found");
        }

        ticketRepository.delete(ticket.get());
    }

    public void deleteAllTickets(){
        ticketRepository.deleteAll();
    }
}
