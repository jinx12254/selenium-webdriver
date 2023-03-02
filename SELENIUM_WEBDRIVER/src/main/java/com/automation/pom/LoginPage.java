package com.automation.pom;

import com.automation.utils.PropertiesFileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriverWait wait;
    private WebDriver driver;
    private String userXpah = PropertiesFileUtils.getProperty("emailTextFlied");
    public LoginPage(WebDriver driver){
        wait = new WebDriverWait(driver, 10);
        this.driver = driver;
    }
    public void loginAndLogout(){
        driver.findElement(By.xpath(PropertiesFileUtils.getProperty("loginButton"))).click();
    }

    public void enterEmail(String userEmail){
        driver.findElement(By.xpath(PropertiesFileUtils.getProperty("emailTextFlied"))).sendKeys(userEmail);
    }

    public void enterPassword(String userPassword){
        driver.findElement(By.xpath(PropertiesFileUtils.getProperty("passwordTextFlied"))).sendKeys(userPassword);
    }

    public void clickEnter(){
        driver.findElement(By.xpath(PropertiesFileUtils.getProperty("enterButton"))).click();
    }
}
