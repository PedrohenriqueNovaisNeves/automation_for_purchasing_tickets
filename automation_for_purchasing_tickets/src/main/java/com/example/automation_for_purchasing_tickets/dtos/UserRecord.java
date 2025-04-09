package com.example.automation_for_purchasing_tickets.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserRecord(@NotBlank String nameUser, @NotBlank String cpfUser, @NotBlank String email, @NotBlank String password) {
}
