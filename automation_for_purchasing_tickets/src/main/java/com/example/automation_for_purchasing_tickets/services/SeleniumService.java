package com.example.automation_for_purchasing_tickets.services;

import com.example.automation_for_purchasing_tickets.models.UserModel;
import com.example.automation_for_purchasing_tickets.repositorys.UserRepository;
import jakarta.annotation.PreDestroy;
import okhttp3.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import javax.print.attribute.standard.Media;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
public class SeleniumService {


    private final WebDriver driver;
    private final UserRepository userRepository;
    private final String API_KEY = "a6f9619d6ba0a56632a33f7a0b12407d";

    public SeleniumService(WebDriver driver, UserRepository userRepository){
        this.driver = driver;
        this.userRepository = userRepository;
    }

    private WebElement waitForElementVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitForElementClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public String buyTicket(String cpfUser) throws IOException {
        Optional<UserModel> user = userRepository.findByCpfUser(cpfUser);
        if(user.isEmpty()){
            new RuntimeException("user not found");
        }

        var userModel = user.get();

        try{

            driver.get("https://www.fieltorcedor.com.br/");

            waitForElementClickable(By.linkText("LOGIN")).click();

            waitForElementVisible(By.id("id_username")).sendKeys(userModel.getCpfUser());
            waitForElementVisible(By.id("id_password")).sendKeys(userModel.getPassword());

            Thread.sleep(10000);

            driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

            waitForElementClickable(By.xpath("//button[contains(@class, 'ingressos')]")).click();

            waitForElementClickable(By.xpath("//div[contains(@class,'submenu')]/a[contains(text(),'Comprar ingressos')]")).click();

            waitForElementClickable(By.linkText("COMPRE AGORA")).click();

            return "ok";
        }catch (NoSuchElementException | TimeoutException | InterruptedException e){
            return "Erro na automação: " + e.getMessage();
        }
    }

}
