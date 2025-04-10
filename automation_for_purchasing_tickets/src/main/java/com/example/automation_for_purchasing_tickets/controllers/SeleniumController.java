package com.example.automation_for_purchasing_tickets.controllers;

import com.example.automation_for_purchasing_tickets.services.SeleniumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/automation")
public class SeleniumController {

//    @Autowired
//    public final SeleniumService seleniumService;
//
//    public SeleniumController(SeleniumService seleniumService){
//        this.seleniumService = seleniumService;
//    }
//
//    @GetMapping("/testar-selenium")
//    public String testar() {
//        seleniumService.testarSelenium();
//        return "Teste concluído!";
//    }
}
