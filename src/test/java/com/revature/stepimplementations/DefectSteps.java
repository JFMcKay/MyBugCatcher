package com.revature.stepimplementations;

import com.revature.bugcatcher.Runner;
import com.revature.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DefectSteps extends AbstractTestNGCucumberTests {
    // Variables to be used between steps

    @Given("The manager is logged in")
    public void the_manager_is_logged_in() {
        Runner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=10");
        Runner.loginPage.usernameInput.sendKeys("g8tor");
        Runner.loginPage.passwordInput.sendKeys("chomp!");
        Runner.loginPage.loginButton.click();
    }

    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        Runner.wait2Driver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h1[contains(text(),\"Manager\")])")));
    }

    @Given("The tester is logged in")
    public void the_tester_is_logged_in() {
        Runner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=10");
        Runner.loginPage.usernameInput.sendKeys("cavalier89");
        Runner.loginPage.passwordInput.sendKeys("alucard");
        Runner.loginPage.loginButton.click();
    }

    @Given("The tester is on the home page")
    public void the_tester_is_on_the_home_page() {
        Runner.wait2Driver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h1[contains(text(),\"Tester\")])")));
    }

    @When("The tester changes to defect to any status")
    public void the_tester_changes_to_defect_to_any_status() {
        // Wait for defects
        Runner.wait2Driver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'My Defects')]")));
        // Set passString to current status button
        Runner.passString = Runner.homePage.statusButton.getText();
        // Click status button
        Runner.homePage.statusButton.click();
        // Wait for drop down
        Runner.wait2Driver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Change Status')]")));
        // Click status button
        Runner.homePage.changeStatusButton.click();
        // Set random button click
        int randomIndex = HomePage.rand.nextInt(Runner.homePage.buttonStatusList.size());
//        int randomIndex = 4;
        System.out.println(randomIndex);
        System.out.println(Runner.homePage.buttonStatusList.size());
        // Create element to store button
        WebElement toClickStatus;
        // Test to see if equal if they are add 1 to index or minus 1
        if (Runner.passString.equals(Runner.homePage.buttonStatusList.get(randomIndex).getText())) {
            System.out.println("They equal");
            System.out.println(randomIndex);
            toClickStatus = Runner.homePage.buttonStatusList.get(randomIndex == Runner.homePage.buttonStatusList.size() ?
                    randomIndex + 1 : randomIndex - 1);
        } else {
            System.out.println("They aren't equal");
            toClickStatus = Runner.homePage.buttonStatusList.get(randomIndex);
        }
        System.out.println(toClickStatus.getText());
        toClickStatus.click();
        Runner.wait2Driver.until(
                ExpectedConditions.textToBePresentInElement(Runner.homePage.statusButton, toClickStatus.getText()));
    }

    @Then("The tester should see the defect has a different status")
    public void the_tester_should_see_the_defect_has_a_different_status() {
        System.out.println(Runner.passString);
        System.out.println(Runner.homePage.statusButton.getText());
        Assert.assertNotEquals(Runner.passString, Runner.homePage.statusButton.getText());
        Runner.passString = null;
    }

    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {
        Runner.wait2Driver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
    }

    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        Runner.homePage.selectDefect.click();
        Runner.passString = Runner.homePage.getId.getText();
    }

    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {
        Runner.wait2Driver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4")));
    }

    @When("The manager selects an tester from the drop down")
    public void the_manager_selects_an_tester_from_the_drop_down() {
        Runner.homePage.listTester.sendKeys("ryeGuy");

    }

    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {
        Runner.homePage.assignButton.click();
    }

    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {
        Assert.assertNotSame(Runner.passString, Runner.homePage.getId.getText());
        ;
    }

    @Then("The tester should see the pending defect")
    public void the_tester_should_see_the_pending_defect() {
        Assert.assertTrue(Runner.homePage.isPending.isDisplayed());
    }

    @Given("The tester is on the Defect Reporter Page")
    public void the_tester_is_on_the_defect_reporter_page() {
        Runner.homePage.reportLink.click();
        Runner.wait2Driver.until(ExpectedConditions.urlContains("/defectreporter"));
    }

    @When("The tester selects todays date")
    public void the_tester_selects_todays_date() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        String strDate = dateFormat.format(date);
        Runner.drPage.dateReported.sendKeys(strDate);

    }

    @When("The tester types in {string} with")
    public void the_tester_types_in_with(String string, String docString) {
        if (string.equals("Description")) {
            Runner.drPage.description.sendKeys(docString);
        } else {
            Runner.drPage.howTo.sendKeys(docString);
        }

    }

    @When("The tester selects high priority")
    public void the_tester_selects_high_priority() {
        for (int i = 0; i <= 3; i++) {
            Runner.drPage.severitySlider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    @When("The tester selects low severity")
    public void the_tester_selects_low_severity() throws InterruptedException {
        for (int i = 3; i >= 0; i--) {
            Runner.drPage.prioritySlider.sendKeys(Keys.ARROW_LEFT);
        }
    }

    @When("The tester clicks the report button")
    public void the_tester_clicks_the_report_button() {
        Runner.drPage.reportButton.click();
    }

    @Then("There should be a confirmation box")
    public void there_should_be_a_confirmation_box() {

    }

    @Then("The tester is at the confirmation box")
    public void the_tester_is_at_the_confirmation_box() {
        if (Runner.wait2Driver.until(ExpectedConditions.alertIsPresent()) == null) {
            System.out.println("alert was not present");
        }
    }

    @Then("The tester clicks Ok")
    public void the_tester_clicks_ok() {
        Runner.driver.switchTo().alert().accept();
    }

    @Then("A modal should appear with a Defect ID")
    public void a_modal_should_appear_with_a_defect_id() {
        Runner.wait2Driver.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("(//h4[starts-with(text(),'Defect ')])")));
    }

    @Then("The tester clicks close")
    public void the_tester_clicks_close() {
        Runner.drPage.modalClose.click();
    }

    @Then("The modal should disappear")
    public void the_modal_should_disappear() {
        Assert.assertTrue(Runner.drPage.reportButton.isEnabled());
    }

    @Given("The employee is on the Defect Reporter Page")
    public void theEmployeeIsOnTheDefectReporterPage() {
        Runner.homePage.reportLink.click();
        Runner.wait2Driver.until(ExpectedConditions.urlContains("/defectreporter"));

    }

    @When("The employee selects todays date")
    public void theEmployeeSelectsTodaysDate() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        String strDate = dateFormat.format(date);
        Runner.drPage.dateReported.sendKeys(strDate);

    }

    @When("The employee types in {string} with")
    public void theEmployeeTypesInWith(String string, String docString) {
        if (string.equals("Description")) {
            Runner.drPage.description.sendKeys(docString);
        } else {
            Runner.drPage.howTo.sendKeys(docString);
        }
    }

    @When("The employee selects high priority")
    public void theEmployeeSelectsHighPriority() {
        for (int i = 0; i <= 3; i++) {
            Runner.drPage.severitySlider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    @When("The employee selects low severity")
    public void theEmployeeSelectsLowSeverity() {
        for (int i = 3; i >= 0; i--) {
            Runner.drPage.prioritySlider.sendKeys(Keys.ARROW_LEFT);
        }
    }

    @When("The employee clicks the report button")
    public void theEmployeeClicksTheReportButton() {
        Runner.drPage.reportButton.click();
    }

    @Then("No confirmation dialog appears")
    public void noConfirmationDialogAppears() {
        // This returns false if there is an alert box.
        Assert.assertTrue(Runner.wait2Driver.until(ExpectedConditions.alertIsPresent()) == null);
    }


    @Then("The employee sees the {string} error message {string}")
    public void theEmployeeSeesTheErrorMessage(String where, String message) {
        if (Objects.equals(where, "Description")) {
            System.out.println(message + "This is the message");
            System.out.println(Runner.drPage.description.getAttribute("validationMessage"));
            Assert.assertEquals(message, Runner.drPage.description.getAttribute("validationMessage"));
        } else {
            System.out.println(message);
            System.out.println(Runner.drPage.dateReported.getAttribute("validationMessage"));
            Assert.assertEquals(message, Runner.drPage.dateReported.getAttribute("validationMessage"));
        }
    }
}
