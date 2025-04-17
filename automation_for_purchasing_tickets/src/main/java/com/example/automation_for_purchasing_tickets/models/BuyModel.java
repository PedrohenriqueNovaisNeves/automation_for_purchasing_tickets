package com.example.automation_for_purchasing_tickets.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_BUY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuyModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idBuy;
    private String purchaseCode;
    private LocalDate dateOfPurchase;
    private String purchasingMethod;
    private BigDecimal purchaseValue;
}
