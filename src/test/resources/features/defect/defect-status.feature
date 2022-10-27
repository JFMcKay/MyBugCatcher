Feature: Defect Status

#Declarative Style
    Background: Tester is logged in
        Given The employee is on the login page
        When  The employee types <username> into username input 
        And The employee types <password> into password input
        And The employee clicks on the login button
        Then the employee should be on the <role> page


    Scenario: Change Status
        Given The tester is on the Home Page 
        When The tester changes to defect to any status
        Then The tester should see the defect has a different status
