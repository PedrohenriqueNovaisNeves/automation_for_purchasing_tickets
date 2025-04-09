package com.example.automation_for_purchasing_tickets.services;

import jakarta.annotation.PreDestroy;
import org.openqa.selenium.*;
import org.springframework.stereotype.Service;

@Service
public class SeleniumService {


    private final WebDriver driver;

    public SeleniumService(WebDriver driver){
        this.driver = driver;
    }

    public void testarSelenium() {
        driver.get("https://www.youtube.com");
        System.out.println("Título da página: " + driver.getTitle());

        // Fecha o navegador (importante se estiver rodando múltiplas vezes)
        //driver.quit();
    }
}
