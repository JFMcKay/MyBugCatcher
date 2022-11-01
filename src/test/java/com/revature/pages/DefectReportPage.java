package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefectReportPage {
    @FindBy(xpath = "//input[@name='dateReported']")
    public WebElement dateReported;
    @FindBy(xpath = "//textarea[@name='desc']")
    public WebElement description;
    @FindBy(xpath = "//textarea[@name='stepsToReproduce']")
    public WebElement howTo;
    @FindBy(xpath = "//input[@name='severity']")
    public WebElement severitySlider;

    @FindBy(xpath = "//input[@name='priority']")
    public WebElement prioritySlider;

    @FindBy(xpath = "//button[contains(text(),'Report')]")
    public WebElement reportButton;
    @FindBy(xpath = "//button[contains(text(),'Close')]")
    public WebElement modalClose;
    public DefectReportPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
