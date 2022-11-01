
Feature: Defect Reporting
    # Added background for login
    Background: Tester is logged in
        Given The tester is logged in 
        Given The tester is on the home page
    # TC-9
    Scenario: Report New Defect
        Given The tester is on the Defect Reporter Page 
        When The tester selects todays date 
        And The tester types in "Description" with
            """
            Users are able to create multiple accounts using the same username but
            with a different password.
            """
        And The tester types in "Steps" with 
            """
            1. User creates a new account
            2. User reloads the new user page
            3. User creates an account with same username but different password
            """
        And The tester selects high priority 
        And The tester selects low severity 
        And The tester clicks the report button 
        # removed some of the steps because they were super redundant about the screens
        Then The tester is at the confirmation box 
        And The tester clicks Ok 
        And A modal should appear with a Defect ID
        # removed some of the steps because they were super redundant about the screens
        And The tester clicks close
        And The modal should disappear
         
