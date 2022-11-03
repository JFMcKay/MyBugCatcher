package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestcasePage {
    @FindBy(xpath = "//textarea[@name='desc']")
    public WebElement description;
    @FindBy(xpath = "//h3")
    public WebElement testCaseModalH3;
    @FindBy(xpath = "//p[contains(text(),'No One')]")
    public WebElement performedBy;
    @FindBy(xpath = "//a[contains(text(),'Edit')]")
    public WebElement editButton;
    @FindBy(xpath = "//button[contains(text(),'Close')]")
    public WebElement closeButton;
    @FindBy(xpath = "//textarea[@name='steps']")
    public WebElement steps;
    @FindBy(xpath = "//tbody/tr[last()]/td[3]")
    public WebElement lastResult;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;
    @FindBy(xpath = "(//button[contains(text(),'Details')])[last()]")
    public WebElement lastDetailsButton;
    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> testRows;
    @FindBy(xpath = "//body")
    public WebElement bodyTag;
    public TestcasePage(WebDriver driver) {
        // Pagefactory is a feature of Selenium that reduces the need to use findElement by introducing the
        // @FindBy annotation
        //This will go and utilize the @FindBy annotations and get the elements automatically for us.
        PageFactory.initElements(driver, this);
    }
}
