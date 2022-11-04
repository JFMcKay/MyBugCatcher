@navigation
Feature: Navigation

    Background: Manager is logged in
        Given The manager is logged in
        Given The manager is on the home page

    Scenario: Back Navigation
        Given The manager is on the home page
        When The manager clicks on Matrices 
        Then The title of the page should be Matrix Page 
        When The manager clicks the browser back button 
        Then The manager should be on the home page and the title of page is Home 
        When The manager clicks on Test Cases
        When The manager clicks the browser back button 
        Then The manager should be on the home page and the title of page is Home 
    
    Scenario Outline: All Links Viable 
        Given The manager is on the home page
        When The manager clicks on "<link>"
        Then The title of page should be "<title>"

        Examples:
            | link           | title               |
            | Matrices       | Matrix Overview     |
            | Test Cases     | Test Case Overview  |
            | Report a Defect| Defect Reporter     |
            | Defect Overview| Defect Overview     |

    Scenario Outline: Home Page Links Visible
        Given The manager is on the home page
        Then The manager should see "<link>" on the page
    
        Examples:
            | link           |
            | Matrices       |
            | Test Cases     |
            | Report a Defect|
            | Defect Overview|
