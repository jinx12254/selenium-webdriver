package com.automation.base;

import com.automation.utils.PropertiesFileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class DriverInstance {
    protected WebDriver driver;
    protected PropertiesFileUtils pro = new PropertiesFileUtils();
    protected Actions act;
    protected WebDriverWait wait;
    @BeforeClass
    public void initDriverInstance(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(PropertiesFileUtils.getProperty("URL"));
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @AfterClass
    public void closeDriverInstance(){
        driver.close();
    }
}
