@navigation
Feature: Navigation

    Background: Manager is logged in
        Given The manager is logged in
        Given The manager is on the home page
    
    Scenario: Home Page Links Visible
        Given The manager is on the the <role> page
        Then The manager should see links <link> on the page 

    Scenario: Back Navigation
        Given The manager is on the the <role> page
        When The manager clicks on Matrices 
        Then The title of the page should be Matrix Page 
        When The manager clicks the browser back button 
        Then The manager should be on the home page and the title of page is Home 
        When The manager clicks on Test Cases
        When The manager clicks the browser back button 
        Then The manager should be on the home page and the title of page is Home 
    
    Scenario Outline: All Links Viable 
        Given The manager is on the the <role> page
        When The manager clicks on <link>
        Then The title of page should be <title>
    
    Examples:
        | link           | title               | 
        | Matrices       | Matrix Overview     |
        | Test Cases     | Test Case Overview  |
        | Report a Defect| Defect Reporter     |
        | Defect Overview| Defect Overview     |
