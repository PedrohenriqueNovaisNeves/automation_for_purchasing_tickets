package com.example.automation_for_purchasing_tickets.dtos;

import jakarta.validation.constraints.NotBlank;

public record TicketRecord(@NotBlank String nameTicket, @NotBlank String sector, @NotBlank String game, @NotBlank String dateOfGame) {
}
