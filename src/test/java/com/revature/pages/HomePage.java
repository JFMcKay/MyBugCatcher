package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class HomePage {
    @FindBy(xpath = "//a[contains(text(),'Matrices')]")
    public  WebElement matricesLink;
    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
    public WebElement testcasesLink;
    @FindBy(xpath = "(//li)[last()]//child::div[last()]/button")
    public List<WebElement> buttonStatusList;
    @FindBy(xpath = "//button[contains(text(),'Assign')]")
    public WebElement assignButton;
    @FindBy(xpath = "//a[contains(text(),'Report a Defect')]")
    public WebElement reportLink;
    @FindBy(xpath="(//p/b)[last()]")
    public WebElement statusButton;
    @FindBy(xpath = "//button[contains(text(),'Change Status')]")
    public WebElement changeStatusButton;
    @FindBy(xpath = "(//button[contains(text(),'Select')])[1]")
    public WebElement selectDefect;
    @FindBy(xpath = "//b[contains(text(),'Pending')]")
    public WebElement isPending;
    @FindBy(xpath = "((//button[contains(text(),'Select')])[1])//ancestor::tr[1]/td[1]")
    public WebElement getId;
    @FindBy(xpath = "//p/b[1]")
    public List<WebElement> bId;
    @FindBy(xpath = "//p[5]")
    public List<WebElement> tester;
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
