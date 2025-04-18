package com.example.automation_for_purchasing_tickets.controllers;


import com.example.automation_for_purchasing_tickets.dtos.BuyRecord;
import com.example.automation_for_purchasing_tickets.models.BuyModel;
import com.example.automation_for_purchasing_tickets.services.BuyService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/buy")
public class BuyController {

    @Autowired
    BuyService buyService;

    @GetMapping("/ping")
    public String ping() {
        return "Pong";
    }


    @PostMapping("/savePurchase")
    public ResponseEntity<Object> savePurchase(@Valid @RequestBody BuyRecord buyRecord){
        buyService.savePurchase(buyRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body("Purchase registered with successfully");
    }

    @GetMapping("/listAllPurchases")
    public ResponseEntity<List<BuyModel>> listAllPurchasing(){
        List<BuyModel> purchases = buyService.listAllPurchases();
        return ResponseEntity.status(HttpStatus.OK).body(purchases);
    }

    @GetMapping("/listOnePurchasing/{id}")
    public ResponseEntity<Object> listOnePurchasing(@PathVariable(value = "id")UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(buyService.listOnePurchase(id));
    }

    @PutMapping("/updatePurchase/{id}")
    public ResponseEntity<Object> updatePurchase(@PathVariable(value = "id")UUID id, @Valid @RequestBody BuyRecord buyRecord){
        var purchase = new BuyModel();
        BeanUtils.copyProperties(buyRecord, purchase);

        buyService.updatePurchase(id, purchase);

        return ResponseEntity.status(HttpStatus.OK).body("register purchasing updated with successfully");
    }
}
