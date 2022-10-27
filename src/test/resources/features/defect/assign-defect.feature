Feature: Assign Defect
 
    Background: Manager is logged in
        Given The employee is on the login page
        When  The employee types <username> into username input 
        And The employee types <password> into password input
        And The employee clicks on the login button
        Then the employee should be on the <role> page

    Scenario: Assign Defect to tester
        Given The manager is on the home page
        Then The manager should see pending defects
        When The manager clicks on the select button for a defect 
        Then The defect description should appear in bold
        When The manager selects an tester from the drop down
        When The manager clicks assign 
        Then The defect should disappear from the list 
        Given The assigned tester is on their home page 
        Then The tester should see the pending defect

    Scenario: See pending defects
        Given The manager is logged in as a manager 
        Given The manager is on the home page
        Then The manager should see pending defects