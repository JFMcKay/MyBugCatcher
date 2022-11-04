package com.revature.stepimplementations;

import com.revature.bugcatcher.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestcasesSteps extends AbstractTestNGCucumberTests {

    @Given("The tester is on the test case dashboard")
    public void theTesterIsOnTheTestCaseDashboard() {
        Runner.homePage.testcasesLink.click();
        Runner.wait2Driver.until(ExpectedConditions.urlContains("/testcases"));
    }

    @When("The tester types {string} into input with")
    public void theTesterTypesIntoInputWith(String string, String docString) {
        if (string.equals("Description")) {
            Runner.tcPage.description.sendKeys(docString);
        } else {
            Runner.tcPage.steps.sendKeys(docString);
        }
    }

    @When("The tester presses the submit button")
    public void theTesterPressesTheSubmitButton() {
        Runner.passInt = 0;
        Runner.passInt = Runner.tcPage.testRows.size();
        Runner.tcPage.submitButton.click();

    }

    @Then("The test case should appear at the bottom of the table")
    public void theTestCaseShouldAppearAtTheBottomOfTheTable() {
        Runner.wait2Driver.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//tbody/tr"), Runner.passInt ));
        System.out.println(Runner.passInt + " "+ Runner.tcPage.testRows.size());
        Assert.assertTrue(Runner.passInt < Runner.tcPage.testRows.size());
    }

    @Then("The test case result should say UNEXECUTED")
    public void theTestCaseResultShouldSayUNEXECUTED() {
        Assert.assertEquals(Runner.tcPage.lastResult.getText(), "UNEXECUTED");

    }

    @When("The tester presses on details")
    public void theTesterPressesOnDetails() {
        Runner.wait2Driver.until(ExpectedConditions.visibilityOf(Runner.tcPage.lastDetailsButton));
        Runner.tcPage.lastDetailsButton.click();
    }

    @Then("A test case modal should appear showing the case ID")
    public void aTestCaseModalShouldAppearShowingTheCaseID() {
        WebElement modal = Runner.wait2Driver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3")));
        Assert.assertNotNull(modal);
    }

    @Then("The performed by field should say No One")
    public void thePerformedByFieldShouldSayNoOne() {
        Assert.assertTrue(Runner.tcPage.performedBy.getText().contains("No One"));
    }

    @Then("The Modal Should be closed")
    public void theModalShouldBeClosed() {
        //Check to see if the body tag is empty after modal is closed and class is removed
        Assert.assertTrue(Runner.tcPage.bodyTag.getAttribute("class").isEmpty());
    }

    @When("The tester clicks on edit within the modal")
    public void theTesterClicksOnEditWithinTheModal() {
        Runner.passString = Runner.tcPage.testCaseModalH3.getText();
        String[] words = Runner.passString.split(" ");
        Runner.passString = words[words.length - 1];
        System.out.println(Runner.passString);
        Runner.tcPage.editButton.click();
    }

    @Then("The tester should be on the case editor for that case")
    public void theTesterShouldBeOnTheCaseEditorForThatCase() {
        Runner.wait2Driver.until(ExpectedConditions.visibilityOf(Runner.cePage.caseID));
        Assert.assertTrue(Runner.cePage.caseID.getText().contains(Runner.passString));
    }
    @When("The tester clicks on the edit button")
    public void theTesterClicksOnTheEditButton() {
        Runner.cePage.editButton.click();
    }
    @Then("The fields should be uneditable")
    public void theFieldsShouldBeUneditable() throws InterruptedException {
        Runner.wait2Driver.until(ExpectedConditions.visibilityOf(Runner.cePage.steps));
        Assert.assertFalse(Runner.driver.findElement(By.xpath("//fieldset[1]/textarea[1]")).isEnabled());
    }


    @Then("The test case fields should be editable")
    public void theTestCaseFieldsShouldBeEditable() {
        Runner.passList = Runner.cePage.textAreas;
        Assert.assertTrue(Runner.cePage.steps.isEnabled());
    }

    @When("The tester types in a new description into the description text area")
    public void theTesterTypesInANewDescriptionIntoTheDescriptionTextArea() {
        Runner.cePage.description.sendKeys("This a description that I entered into the description");
    }

    @When("The tester types in a new steps into the steps text area")
    public void theTesterTypesInANewStepsIntoTheStepsTextArea() {
        Runner.cePage.steps.sendKeys("1. Type stuff\n2. Type more stuff\n3. Hopefully it's not broken");
    }

    @When("The tester clicks on the automated check mark")
    public void theTesterClicksOnTheAutomatedCheckMark() {
        Runner.cePage.check.click();
    }

    @When("The tester selects ryeGuy for performed from drop down")
    public void theTesterSelectsRyeGuyForPerformedFromDropDown() {
        Select dropDown = new Select(Runner.cePage.selectTester);
        dropDown.selectByValue("ryeGuy");

    }

    @When("The tester selects FAIL for test result from drop down")
    public void theTesterSelectsFAILForTestResultFromDropDown() {
        Select dropDown = new Select(Runner.cePage.selectResult);
        dropDown.selectByValue("FAIL");
    }

    @When("The tester types in a new summary into the summary text area")
    public void theTesterTypesInANewSummaryIntoTheSummaryTextArea() {
        Runner.cePage.summary.sendKeys("This test failed probably because feature files were written terribly");
    }

    @When("The tester clicks save on test case page")
    public void theTesterClicksSaveOnTestCasePage() {
        Runner.cePage.saveButton.click();
    }

    @Then("A confirmation prompt should appear")
    public void aConfirmationPromptShouldAppear() {
        Assert.assertNotNull(Runner.wait2Driver.until(ExpectedConditions.alertIsPresent()));
    }

    @When("The tester clicks on Ok")
    public void theTesterClicksOnOk() {
        Runner.driver.switchTo().alert().accept();
    }

    @Then("An alert says the test case has been saved")
    public void anAlertSaysTheTestCaseHasBeenSaved() {
        if(Runner.wait2Driver.until(ExpectedConditions.alertIsPresent())==null){
            System.out.println("alert was not present");
        }
        else
        {
            Alert actualAlertText = Runner.driver.switchTo().alert();
            Assert.assertEquals(actualAlertText.getText(), "Test Case has been Saved");
            actualAlertText.accept();
        }
    }


    @When("The tester clicks on the reset button")
    public void theTesterClicksOnTheResetButton() {
        Runner.cePage.resetButton.click();
    }

    @Then("The fields should be populated to their old values")
    public void theFieldsShouldBePopulatedToTheirOldValues() {
        for(WebElement e:Runner.passList) {
            Assert.assertTrue(Runner.cePage.textAreas.contains(e));
        }
    }


    @When("The tester presses the close button")
    public void theTesterPressesTheCloseButton() {

        Runner.tcPage.closeButton.click();
    }
}
