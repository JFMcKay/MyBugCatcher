Feature: Assign Defect
 
   Background: Manager is logged in
        Given The manager is logged in 
        Given The manager is on the home page

    Scenario: Assign Defect to tester
        Given The manager is on the home page
        Then The manager should see pending defects
        When The manager clicks on the select button for a defect 
        Then The defect description should appear in bold
        When The manager selects an tester from the drop down
        When The manager clicks assign 
        Then The defect should disappear from the list 

    Scenario: Tester sees assigned defect
        Given The assigned tester is on their home page 
        Then The tester should see the pending defect

    Scenario: See pending defects
        Given The manager is on the home page
        Then The manager should see pending defects