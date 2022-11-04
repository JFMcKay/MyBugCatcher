package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MatrixPage {
    @FindBy(xpath = "(//ul/li)[last()]")
    public WebElement lastTitle;
    @FindBy(xpath = "(//ul/li[last()])//button[contains(text(),'Show')]")
    public WebElement lastShowButton;
    @FindBy(xpath = "(//ul/li[last()])//button[contains(text(),'Edit')]")
    public WebElement lastEditButton;
    @FindBy(xpath = "((//*/div/ul[1]/li[last()])//*/button[contains(text(),'Add')])[1]")
    public WebElement addTestButton;
    @FindBy(xpath = "((//*/div/ul[1]/li[last()])//*/button[contains(text(),'Remove')])[1]")
    public WebElement removeTextButton;
    @FindBy(xpath = "((//*/div/ul[1]/li[last()])//*/button[contains(text(),'Add')])[2]")
    public WebElement addDefectButton;
    @FindBy(xpath = "((//*/div/ul[1]/li[last()])//*/button[contains(text(),'Remove')])[1]")
    public WebElement removeDefectButton;
    @FindBy(xpath = "(//*/button[contains(text(),'Save Requirements')])[last()]")
    public WebElement saveRequirements;
    @FindBy(xpath = "(//*/div/ul[1]/li)[last()]//input")
    public WebElement testCaseInput;
    @FindBy(xpath = "(//*/div/ul[2]/li)[last()]//input")
    public WebElement defectIdInput;

    public MatrixPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
