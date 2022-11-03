@defect
Feature: Defect Status

   Background: Tester is logged in
        Given The tester is logged in 
        Given The tester is on the home page

    Scenario: Change Status
        Given The tester is on the home page 
        Then The tester can can see only defects assigned to them
        When The tester changes to defect to any status
        Then The tester should see the defect has a different status
