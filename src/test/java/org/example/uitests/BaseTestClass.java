package org.example.uitests;

import org.example.uitests.driver.Browser;
import org.example.uitests.driver.WebDriverFactory;
import org.example.uitests.driver.WebDriverFactory2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTestClass {
    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {
//        System.setProperty("browser", "firefox");
//        driver = new ChromeDriver();                         // Варіант 1: Просто викликати WebDriver
//        driver = WebDriverFactory.getDriver(Browser.CHROME); // Варіант 2: Передати його через створену WebDriver Factory
        driver = WebDriverFactory2.getDriver();                // Варіант 3: Через config.properties
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Display system variables
    public static void main(String[] args) {
        System.getProperties().forEach((k, v) ->System.out.println(k + " " + v));
    }
}