package com.revature.bugcatcher;

import com.revature.pages.*;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


@CucumberOptions(features = "classpath:features",
                glue="com.revature.stepimplementations", tags = "@defect")
public class Runner extends AbstractTestNGCucumberTests {
//https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=10
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static TestcasePage tcPage;
    public static DefectReportPage drPage;
    public static CaseEditorPage cePage;
    public static MatrixPage matrixPage;
    public static WebDriverWait wait2Driver;
    // static variables used for passing
    public static String passString;

    public static String curUser;
    public static int passInt;
    public static WebElement passElement;
    public static boolean passBool;

    public static List<WebElement> passList;
    @BeforeMethod // Runs before each scenario
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        wait2Driver = new WebDriverWait(driver, Duration.ofSeconds(10));
        matrixPage = new MatrixPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        drPage = new DefectReportPage(driver);
        tcPage = new TestcasePage(driver);
        cePage = new CaseEditorPage(driver);
        passList = new ArrayList<>();
        curUser = "cavalier89";
        passInt = 0;
        passBool = true;
        passString = null;
        passElement = null;
    }
    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }


}
