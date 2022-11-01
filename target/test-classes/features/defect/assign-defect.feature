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
# Fails because incomplete
    Scenario: Tester sees assigned defect
        Given The tester is on the home page 
        Then The tester should see the pending defect
# rewritten properly so it can be tested properly, JM Created
    Scenario: Tester logs in to see assigned defects
        Given The tester is logged in
        Given The tester is on the home page
        Then The tester should see the pending defect
# An edge case that will fail if there is no pending defects which is the same for the first scenario.
    Scenario: See pending defects
        Given The manager is on the home page
        Then The manager should see pending defects