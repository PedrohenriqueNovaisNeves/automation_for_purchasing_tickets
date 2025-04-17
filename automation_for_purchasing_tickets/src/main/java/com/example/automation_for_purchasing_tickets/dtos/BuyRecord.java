package com.example.automation_for_purchasing_tickets.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BuyRecord(@NotBlank String purchaseCode, @NotNull LocalDate dateOfPurchase, @NotBlank String purchasingMethod, @NotNull BigDecimal purchaseValue){
}
