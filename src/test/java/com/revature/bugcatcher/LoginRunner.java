package com.revature.bugcatcher;


import com.revature.pages.LoginPage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


@CucumberOptions(features = "classpath:features/login", glue="com.revature.stepimplementations")
public class LoginRunner extends AbstractTestNGCucumberTests {
//https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=10


    public static WebDriver driver;
    public static LoginPage loginPage;

    @BeforeMethod // Runs before each scenario
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}