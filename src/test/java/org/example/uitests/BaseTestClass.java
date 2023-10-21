package org.example.uitests;

import org.example.uitest.Browser;
import org.example.uitest.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTestClass {
    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {
//        driver = WebDriverFactory.getDriver();
//        System.setProperty("browser", "chrome");
//        driver = WebDriverFactory2.getDriver();
//        driver = WebDriverFactory.getDriver(Browser.CHROME);
//        System.setProperty("browser", "firefox");
//        driver = WebDriverFactory2.getDriver();

//        driver = new ChromeDriver();                       // Варіант 1: Просто викликати WebDriver
        driver = WebDriverFactory.getDriver(Browser.CHROME); // Варіант 2: Передати його через створену WebDriver Factory
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