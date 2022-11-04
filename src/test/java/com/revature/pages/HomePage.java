package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class HomePage {

    @FindBy(xpath = "//a[contains(text(),'Matrices')]")
    public WebElement matricesLink;
    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
    public WebElement testcasesLink;
    @FindBy(xpath = "//a[contains(text(),'Defect Overview')]")
    public WebElement defectOverviewLink;
    @FindBy(xpath = "(//li)[last()]//child::div[last()]/button")
    public List<WebElement> buttonStatusList;
    @FindBy(xpath = "//button[contains(text(),'Assign')]")
    public WebElement assignButton;
    @FindBy(xpath = "//a[contains(text(),'Report a Defect')]")
    public WebElement reportLink;
    @FindBy(xpath="(//ul//li)[last()]")
    public WebElement statusButton;
    @FindBy(xpath = "(//button[contains(text(),'Change Status')])[last()]")
    public WebElement changeStatusButton;
    @FindBy(xpath = "(//button[contains(text(),'Select')])[1]")
    public WebElement selectDefect;
    @FindBy(xpath = "//b[contains(text(),'Pending')]")
    public WebElement isPending;

    @FindBy(xpath = "(//button[contains(text(),'Fixed')])[last()]")
    public WebElement fixedButton;
    @FindBy(xpath = "((//button[contains(text(),'Select')])[1])//ancestor::tr[1]/td[1]")
    public WebElement getId;
    @FindBy(xpath = "(//ul//li)")
    public List<WebElement> bId;
    @FindBy(xpath = "//p[5]")
    public List<WebElement> tester;
    @FindBy(xpath = "//input[@list='employees']")
    public WebElement listTester;
    public static Random rand;
    // NAVIGATION

    @FindBy(xpath = "((//a)//preceding::a)//preceding::a")
    public List<WebElement> allLinks;

    // MATRIX STUFF AFTER THIS

    @FindBy (xpath = "//input[@placeholder='Note']")
    public WebElement noteInput;
    @FindBy(xpath = "//tbody//tr//td//select")
    public WebElement prioritySelect;
    @FindBy(xpath = "//input[@placeholder='User Story']")
    public WebElement userStoryInput;
    @FindBy(xpath = "//button[contains(text(),'Add Requirement')]")
    public WebElement addRequirementButton;
    @FindBy(xpath = "//input[@name='title']")
    public WebElement titleInput;
    @FindBy(xpath = "//h2[contains(text(),'New matrix')]")
    public WebElement h2Matrix;
    @FindBy(xpath = "//button[contains(text(),'Create A new Requirements Matrix')]")
    public WebElement newMatrixButton;

    @FindBy(xpath = "//button[contains(text(),'Create Matrix')]")
    public WebElement createMatrix;


    public HomePage(WebDriver driver) {
        rand = new Random();
        // Pagefactory is a feature of Selenium that reduces the need to use findElement by introducing the
        // @FindBy annotation
        //This will go and utilize the @FindBy annotations and get the elements automatically for us.
        PageFactory.initElements(driver, this);
    }
}
