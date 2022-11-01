package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestcasePage {
    @FindBy(xpath = "//textarea[@name='desc']")
    public WebElement description;

    @FindBy(xpath = "")
    public WebElement steps;

    @FindBy(xpath = "")
    public WebElement submitButton;

    @FindBy(xpath = "")
    public WebElement addMatrix;

    public TestcasePage(WebDriver driver) {
        // Pagefactory is a feature of Selenium that reduces the need to use findElement by introducing the
        // @FindBy annotation
        //This will go and utilize the @FindBy annotations and get the elements automatically for us.
        PageFactory.initElements(driver, this);
    }
}
