package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CaseEditorPage {
    @FindBy(xpath = "//h1")
    public WebElement caseID;
    @FindBy(xpath = "//button[contains(text(),'Edit')]")
    public WebElement editButton;
    @FindBy(xpath = "//fieldset[1]/textarea[1]")
    public WebElement description;

    @FindBy(xpath = "//fieldset/textarea")
    public List<WebElement> textAreas;
    @FindBy(xpath = "//fieldset[1]/textarea[2]")
    public WebElement steps;
    @FindBy(xpath = "//fieldset[2]/textarea[1]")
    public WebElement summary;
    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement check;
    @FindBy(xpath = "(//select)[1]")
    public WebElement selectTester;
    @FindBy(xpath = "(//select)[last()]")
    public WebElement selectResult;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    public WebElement saveButton;
    @FindBy(xpath = "//button[contains(text(),'Reset')]")
    public WebElement resetButton;


    public CaseEditorPage(WebDriver driver) {
        // Pagefactory is a feature of Selenium that reduces the need to use findElement by introducing the
        // @FindBy annotation
        //This will go and utilize the @FindBy annotations and get the elements automatically for us.
        PageFactory.initElements(driver, this);
    }
}
