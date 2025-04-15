package com.example.automation_for_purchasing_tickets.models;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_TICKET")
public class TicketsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTicket;
    private String nameTicket;
    private String sector;
    private String game;
    private LocalDate dateOfGame;

    public UUID getIdTicket() {
        return idTicket;
    }

    public String getNameTicket() {
        return nameTicket;
    }

    public String getSector() {
        return sector;
    }

    public String getGame() {
        return game;
    }

    public LocalDate getDateOfGame() {
        return dateOfGame;
    }

    public void setIdTicket(UUID idTicket) {
        this.idTicket = idTicket;
    }

    public void setNameTicket(String nameTicket) {
        this.nameTicket = nameTicket;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public void setDateOfGame(LocalDate dateOfGame) {
        this.dateOfGame = dateOfGame;
    }
}
