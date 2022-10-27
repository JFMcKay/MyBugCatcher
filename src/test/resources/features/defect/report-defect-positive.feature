Feature: Defect Reporting 
    # Added background for login
    Background: Tester is logged in
        Given The employee is on the login page
        When  The employee types <username> into username input 
        And The employee types <password> into password input
        And The employee clicks on the login button
        Then the employee should be on the <role> page

    Scenario: Report New Defect
        Given The employee is on the Defect Reporter Page 
        When The employee selects todays date 
        When The employee types in "Description" with
            """
            Users are able to create multiple accounts using the same username but
            with a different password.
            """
        When The employee types in "Steps" with 
            """
            1. User creates a new account
            2. User reloads the new user page
            3. User creates an account with same username but different password
            """
        When The employee selects high priority 
        When The employee selects low severity 
        When The employee clicks the report button 
        Then There should be a confirmation box 
        When The employee clicks Ok 
        Then A modal should appear with a Defect ID
        When The employee clicks close
        Then The modal should disappear
         
