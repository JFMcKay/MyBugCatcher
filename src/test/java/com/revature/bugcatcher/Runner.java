package com.revature.bugcatcher;


import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


@CucumberOptions(features = "classpath:features/defect", glue="com.revature.stepimplementations")
public class Runner extends AbstractTestNGCucumberTests {
//https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=010
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static WebDriverWait wait2Driver;

    @BeforeMethod // Runs before each scenario
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        wait2Driver = new WebDriverWait(driver, Duration.ofSeconds(2));
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
