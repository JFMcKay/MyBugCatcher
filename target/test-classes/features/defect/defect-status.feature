Feature: Defect Status

#Declarative Style
   Background: Tester is logged in
        Given The tester is logged in 
        Given The tester is on the home page

    Scenario: Change Status
        Given The tester is on the home page 
        When The tester changes to defect to any status
        Then The tester should see the defect has a different status
