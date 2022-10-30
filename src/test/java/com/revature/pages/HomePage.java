package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class HomePage {

    @FindBy(xpath = "(//tbody)[1]")
    public WebElement firstTbody;
    @FindBy(xpath = "(//div[@class=\"Collapsible__contentInner\"])/button")
    public List<WebElement> buttonStatusList;
    @FindBy(xpath = "//button[contains(text(),'Assign')]")
    public WebElement assignButton;

    @FindBy(xpath="(//p/b)[last()]")
    public WebElement statusButton;
    @FindBy(xpath = "//button[contains(text(),'Change Status')]")
    public WebElement changeStatusButton;
    @FindBy(xpath = "//button[contains(text()='Select')]")
    public WebElement selectDefect;
    @FindBy(xpath = "//input[@list='employees']")
    public WebElement listTester;

    public static Random rand;
    public HomePage(WebDriver driver) {
        rand = new Random();
        // Pagefactory is a feature of Selenium that reduces the need to use findElement by introducing the
        // @FindBy annotation
        //This will go and utilize the @FindBy annotations and get the elements automatically for us.
        PageFactory.initElements(driver, this);
    }
}
