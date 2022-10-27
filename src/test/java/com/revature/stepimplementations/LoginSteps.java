package com.revature.stepimplementations;

import com.revature.bugcatcher.LoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.AbstractTestNGCucumberTests;


public class LoginSteps extends AbstractTestNGCucumberTests {
    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        LoginRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=10");
    }
    @When("The employee types g8tor into username input")
    public void the_employee_types_g8tor_into_username_input() {
        // Write code here that turns the phrase above into concrete actions
        LoginRunner.loginPage.usernameInput.sendKeys("g8tor");

    }
    @When("The employee types chomp! into password input")
    public void the_employee_types_chomp_into_password_input() {
        // Write code here that turns the phrase above into concrete actions
        LoginRunner.loginPage.passwordInput.sendKeys("chomp!");

    }
    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        LoginRunner.loginPage.loginButton.click();
    }
    @Then("the employee should be on the Manager page")
    public void the_employee_should_be_on_the_manager_page() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("The employee should see their name Patty Pastiche on the home page")
    public void the_employee_should_see_their_name_patty_pastiche_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
    }
    @When("The employee types in g8tor into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("The employee types in chomp! into the password input")
    public void the_employee_types_in_chomp_into_the_password_input() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {
        // Write code here that turns the phrase above into concrete actions
    }
    @When("The employee types ryeGuy into username input")
    public void the_employee_types_rye_guy_into_username_input() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("The employee types coolbeans into password input")
    public void the_employee_types_coolbeans_into_password_input() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("the employee should be on the Tester page")
    public void the_employee_should_be_on_the_tester_page() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("The employee should see their name Fakey McFakeFace on the home page")
    public void the_employee_should_see_their_name_fakey_mc_fake_face_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("The employee types cavalier89 into username input")
    public void the_employee_types_cavalier89_into_username_input() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("The employee types alucard into password input")
    public void the_employee_types_alucard_into_password_input() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("The employee should see their name Dracula Fangs on the home page")
    public void the_employee_should_see_their_name_dracula_fangs_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
    }
    @When("The employee types in sicEmDawgs into the username input")
    public void the_employee_types_in_sic_em_dawgs_into_the_username_input() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("The employee types in natchamps into the password input")
    public void the_employee_types_in_natchamps_into_the_password_input() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("There should be a confirmation box")
    public void there_should_be_a_confirmation_box() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("The employee clicks Ok")
    public void the_employee_clicks_ok() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("A modal should appear with a Defect ID")
    public void a_modal_should_appear_with_a_defect_id() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("The employee clicks close")
    public void the_employee_clicks_close() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("The modal should disappear")
    public void the_modal_should_disappear() {
        // Write code here that turns the phrase above into concrete actions

    }
}
