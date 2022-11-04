package com.revature.stepimplementations;

import com.revature.bugcatcher.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class NavigationSteps {



    @When("The manager clicks on Matrices")
    public void theManagerClicksOnMatrices() {
        Runner.homePage.matricesLink.click();
    }

    @Then("The title of the page should be Matrix Page")
    public void theTitleOfThePageShouldBeMatrixPage() {
        Runner.wait2Driver.until(ExpectedConditions.visibilityOf(Runner.matrixPage.lastShowButton));
        Assert.assertTrue(Runner.driver.getTitle().contains("Matrix Overview"));
    }

    @When("The manager clicks the browser back button")
    public void theManagerClicksTheBrowserBackButton() {
        Runner.driver.navigate().back();
    }

    @Then("The manager should be on the home page and the title of page is Home")
    public void theManagerShouldBeOnTheHomePageAndTheTitleOfPageIsHome() {
        Runner.wait2Driver.until(ExpectedConditions.visibilityOf(Runner.homePage.createMatrix));
        Assert.assertTrue(Runner.driver.getTitle().contains("Home"));
    }

    @When("The manager clicks on Test Cases")
    public void theManagerClicksOnTestCases() {
        Runner.homePage.testcasesLink.click();
    }


    @Then("The manager should see {string} on the page")
    public void theManagerShouldSeeLinksOnThePage(String link) {
        for(WebElement e: Runner.homePage.allLinks) {
            Assert.assertTrue(e.getText().contains(link), "Testing if the text and link text matches" + e.getText() + " " + link);
        }
    }

    @When("The manager clicks on {string}")
    public void theManagerClicksOn(String link) {
        switch (link) {
            case "Matrices":  Runner.homePage.matricesLink.click();
                break;
            case "Test Cases":  Runner.homePage.testcasesLink.click();
                break;
            case "Report a Defect":  Runner.homePage.reportLink.click();
                break;
            case "Defect Overview":  Runner.homePage.defectOverviewLink.click();
                break;
            default:
                System.out.println("Something went wrong");
                break;
        }

    }

    @Then("The title of page should be {string}")
    public void theTitleOfPageShouldBe(String link
    ) {
        Runner.wait2Driver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body")));
        Assert.assertTrue(Runner.driver.getTitle().contains(link), "Testing if the text and link text matches" + Runner.driver.getTitle() + " " + link);

    }
}
