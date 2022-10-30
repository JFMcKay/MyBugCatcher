package com.revature.stepimplementations;
import com.revature.bugcatcher.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class DefectSteps extends AbstractTestNGCucumberTests {
    // Variables to be used between steps
    private String passString = null;
    @Given("The manager is logged in")
    public void the_manager_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        Runner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=10");
        Runner.loginPage.usernameInput.sendKeys("g8tor");
        Runner.loginPage.passwordInput.sendKeys("chomp!");
        Runner.loginPage.loginButton.click();
    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        Runner.wait2Driver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h1[contains(text(),\"Manager\")])")));

    }
    @Given("The tester is logged in")
    public void the_tester_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        Runner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=10");
        Runner.loginPage.usernameInput.sendKeys("cavalier89");
        Runner.loginPage.passwordInput.sendKeys("alucard");
        Runner.loginPage.loginButton.click();
    }
    @Given("The tester is on the home page")
    public void the_tester_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        Runner.wait2Driver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h1[contains(text(),\"Tester\")])")));

    }

    @When("The tester changes to defect to any status")
    public void the_tester_changes_to_defect_to_any_status() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

        // Wait for defects
        Runner.wait2Driver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'My Defects')]")));
        // Set passString to current status button
        passString = Runner.homePage.statusButton.getText();
        // Click status button
        Runner.homePage.statusButton.click();
        // Wait for drop down
        Runner.wait2Driver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Change Status')]")));
        // Click status button
        Runner.homePage.changeStatusButton.click();
        // Set random button click
        int randomIndex = Runner.homePage.rand.nextInt(Runner.homePage.buttonStatusList.size());
//        int randomIndex = 4;
        System.out.println(randomIndex);
        System.out.println(Runner.homePage.buttonStatusList.size());
        // Create element to store button
        WebElement toClickStatus;
        // Test to see if equal if they are add 1 to index or minus 1
        if (passString.equals(Runner.homePage.buttonStatusList.get(randomIndex).getText())) {
            System.out.println("They equal");
            System.out.println(randomIndex);
            toClickStatus = Runner.homePage.buttonStatusList.get(randomIndex == Runner.homePage.buttonStatusList.size() ?
                    randomIndex + 1 : randomIndex -1);
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
    public void the_tester_should_see_the_defect_has_a_different_status() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(passString);
        System.out.println(Runner.homePage.statusButton.getText());
        Assert.assertNotEquals(passString, Runner.homePage.statusButton.getText());
    }

    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {
        // Write code here that turns the phrase above into concrete actions
        Runner.wait2Driver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
    }
    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        // Write code here that turns the phrase above into concrete actions
        Runner.homePage.selectDefect.click();
    }
    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {
        // Write code here that turns the phrase above into concrete actions
        Runner.wait2Driver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4")));
    }
    @When("The manager selects an tester from the drop down")
    public void the_manager_selects_an_tester_from_the_drop_down() {
        // Write code here that turns the phrase above into concrete actions
        Runner.homePage.listTester.sendKeys("ryeGuy");

    }
    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {
        // Write code here that turns the phrase above into concrete actions
        Runner.homePage.assignButton.click();
    }
    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Dimension whatSize = Runner.homePage.firstTbody.getSize();
        System.out.println(whatSize);
        Thread.sleep(10000);
    }
    @Given("The assigned tester is on their home page")
    public void the_assigned_tester_is_on_their_home_page() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("The tester should see the pending defect")
    public void the_tester_should_see_the_pending_defect() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Given("The employee is on the Defect Reporter Page")
    public void the_employee_is_on_the_defect_reporter_page() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("The employee selects todays date")
    public void the_employee_selects_todays_date() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("The employee types in {string} with")
    public void the_employee_types_in_with(String string, String docString) {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("The employee selects high priority")
    public void the_employee_selects_high_priority() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("The employee selects low severity")
    public void the_employee_selects_low_severity() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("The employee clicks the report button")
    public void the_employee_clicks_the_report_button() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("No confirmation dialog appears")
    public void no_confirmation_dialog_appears() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Given("The tester is on the Defect Reporter Page")
    public void the_tester_is_on_the_defect_reporter_page() {
        // Write code here that turns the phrase above into concrete action
    }
    @When("The tester selects todays date")
    public void the_tester_selects_todays_date() {
        // Write code here that turns the phrase above into concrete action
    }
    @When("The tester types in {string} with")
    public void the_tester_types_in_with(String string, String docString) {
        // Write code here that turns the phrase above into concrete action
    }
    @When("The tester selects high priority")
    public void the_tester_selects_high_priority() {
        // Write code here that turns the phrase above into concrete action
    }
    @When("The tester selects low severity")
    public void the_tester_selects_low_severity() {
        // Write code here that turns the phrase above into concrete action
    }
    @When("The tester clicks the report button")
    public void the_tester_clicks_the_report_button() {
        // Write code here that turns the phrase above into concrete action
    }
    @Then("There should be a confirmation box")
    public void there_should_be_a_confirmation_box() {
        // Write code here that turns the phrase above into concrete action
    }
    @Then("The tester is at the confirmation box")
    public void the_tester_is_at_the_confirmation_box() {
        // Write code here that turns the phrase above into concrete action
    }
    @Then("The tester clicks Ok")
    public void the_tester_clicks_ok() {
        // Write code here that turns the phrase above into concrete action
    }
    @Then("A modal should appear with a Defect ID")
    public void a_modal_should_appear_with_a_defect_id() {
        // Write code here that turns the phrase above into concrete action
    }
    @Then("The tester is at the modal")
    public void the_tester_is_at_the_modal() {
        // Write code here that turns the phrase above into concrete action
    }
    @Then("The tester clicks close")
    public void the_tester_clicks_close() {
        // Write code here that turns the phrase above into concrete action
    }
    @Then("The modal should disappear")
    public void the_modal_should_disappear() {
        // Write code here that turns the phrase above into concrete action
    }
}
