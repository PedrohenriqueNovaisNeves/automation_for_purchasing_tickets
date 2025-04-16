package com.example.automation_for_purchasing_tickets.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TicketRecord(@NotBlank String nameTicket, @NotBlank String sector, @NotBlank String game, @NotNull LocalDate dateOfGame) {
}