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

    public UUID getIdBuy() {
        return idBuy;
    }

    public String getPurchaseCode() {
        return purchaseCode;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public String getPurchasingMethod() {
        return purchasingMethod;
    }

    public BigDecimal getPurchaseValue() {
        return purchaseValue;
    }

    public void setIdBuy(UUID idBuy) {
        this.idBuy = idBuy;
    }

    public void setPurchaseCode(String purchaseCode) {
        this.purchaseCode = purchaseCode;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setPurchasingMethod(String purchasingMethod) {
        this.purchasingMethod = purchasingMethod;
    }

    public void setPurchaseValue(BigDecimal purchaseValue) {
        this.purchaseValue = purchaseValue;
    }
}
