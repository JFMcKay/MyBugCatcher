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
import org.testng.Assert;


public class LoginSteps extends AbstractTestNGCucumberTests {
    public LoginSteps() {
    }

    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        Runner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=10");
    }
    @When("The employee types {string} into username input")
    public void the_employee_types_into_username_input(String username) {
        Runner.loginPage.usernameInput.sendKeys(username.trim());
    }
    @When("The employee types {string} into password input")
    public void the_employee_types_into_password_input(String password) {
        Runner.loginPage.passwordInput.sendKeys(password.trim());
    }
    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        Runner.loginPage.loginButton.click();
    }
    @Then("the employee should be on the {string} page")
    public void the_employee_should_be_on_the_page(String expectedRole) {
        // Add the waiting for h1 with Role
        WebElement weActualRole = Runner.wait2Driver
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h1[contains(text(),\"" + expectedRole + "\")])")));

        String actualRole = weActualRole.getText();
        Assert.assertTrue(actualRole.contains(expectedRole));

    }
    @Then("The employee should see their name {string} {string} on the home page")
    public void the_employee_should_see_their_name_on_the_home_page(String string, String string2) {
        WebElement weActualName = Runner.wait2Driver.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//p[1]")));
        String expectedName = string + " " + string2;
        Assert.assertTrue(weActualName.getText().contains(expectedName));
    }

    @Then("The employee should see an alert saying {string}")
    public void the_employee_should_see_an_alert_saying(String expectedAlertTest) {
        if(Runner.wait2Driver.until(ExpectedConditions.alertIsPresent())==null){
            System.out.println("alert was not present");
        }
        else
        {
            Alert actualAlertText = Runner.driver.switchTo().alert();
            Assert.assertEquals(actualAlertText.getText(), expectedAlertTest);
            actualAlertText.accept();
        }
    }
}
