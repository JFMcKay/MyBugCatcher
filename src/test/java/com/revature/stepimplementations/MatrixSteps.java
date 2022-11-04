package com.revature.stepimplementations;

import com.revature.bugcatcher.Runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MatrixSteps {
    @Then("A manager can pull up a form to make a new matrix")
    public void aManagerCanPullUpAFormToMakeANewMatrix() {
        Runner.homePage.newMatrixButton.click();
        Assert.assertTrue(Runner.wait2Driver.until(ExpectedConditions.visibilityOf(Runner.homePage.h2Matrix)).isDisplayed());
    }

    @When("A manager creates a title for a matrix")
    public void aManagerCreatesATitleForAMatrix() {
        Runner.passString = "This is a title for the automated test";
        Runner.homePage.titleInput.sendKeys(Runner.passString);
    }

    @And("A manager adds requirements to a matrix")
    public void aManagerAddsRequirementsToAMatrix() {
        Runner.wait2Driver.until(ExpectedConditions.visibilityOf(Runner.homePage.userStoryInput));
        Runner.homePage.userStoryInput.sendKeys("Better Rating System");
        Select pSelect = new Select(Runner.homePage.prioritySelect);
        pSelect.selectByIndex(2);
        Runner.homePage.addRequirementButton.click();
    }

    @When("A manager saves a matrix")
    public void aManagerSavesAMatrix() {
        Runner.homePage.createMatrix.click();
        if(Runner.wait2Driver.until(ExpectedConditions.alertIsPresent())==null){
            System.out.println("alert was not present");
        }
        else
        {
            Alert actualAlertText = Runner.driver.switchTo().alert();
            actualAlertText.accept();
        }
    }

    @Then("The matrix should be visible for all testers and managers")
    public void theMatrixShouldBeVisibleForAllTestersAndManagers() {
        Runner.homePage.matricesLink.click();
        Runner.wait2Driver.until(ExpectedConditions.visibilityOf(Runner.matrixPage.lastTitle));
        Assert.assertTrue(Runner.matrixPage.lastTitle.getText().contains(Runner.passString));

    }

    @Given("A manager or tester has selected a matrix")
    public void aManagerOrTesterHasSelectedAMatrix() {
        Runner.wait2Driver.until(ExpectedConditions.visibilityOf(Runner.matrixPage.lastShowButton));
        Runner.matrixPage.lastShowButton.click();
    }

    @When("A manager or tester adds or removes defects")
    public void aManagerOrTesterAddsOrRemovesDefects() {
        Runner.wait2Driver.until(ExpectedConditions.visibilityOf(Runner.matrixPage.lastEditButton));
        Runner.matrixPage.lastEditButton.click();
        Runner.wait2Driver.until(ExpectedConditions.visibilityOf(Runner.matrixPage.addDefectButton));
        Runner.matrixPage.addDefectButton.click();
        Runner.matrixPage.removeDefectButton.click();
        Runner.matrixPage.lastEditButton.click();
    }

    @When("A manager or tester confirms their changes")
    public void aManagerOrTesterConfirmsTheirChanges() {
        Runner.matrixPage.saveRequirements.click();
    }

    @Then("Then the matrix should saved")
    public void thenTheMatrixShouldSaved() {
        if(Runner.wait2Driver.until(ExpectedConditions.alertIsPresent())==null){
            System.out.println("alert was not present");
        }
        else
        {
            Alert actualAlertText = Runner.driver.switchTo().alert();
            Assert.assertEquals(actualAlertText.getText(), "Matrix Saved");
            actualAlertText.accept();
        }
    }

    @When("A manager or tester adds or removes Test Cases")
    public void aManagerOrTesterAddsOrRemovesTestCases() {
        Runner.wait2Driver.until(ExpectedConditions.visibilityOf(Runner.matrixPage.lastEditButton));
        Runner.matrixPage.lastEditButton.click();
        Runner.matrixPage.addTestButton.click();
        Runner.matrixPage.removeTextButton.click();
        Runner.matrixPage.lastEditButton.click();
    }

    @Given("A manager or tester is on the matrices page")
    public void aManagerOrTesterIsOnTheMatricesPage() {
        Runner.homePage.matricesLink.click();

    }
}
