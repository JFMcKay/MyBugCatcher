Feature: Defect Reporting

    Background: Tester is logged in
            Given The employee is on the login page
            When  The employee types <username> into username input 
            When The employee types <password> into password input
            When The employee clicks on the login button
            Then the employee should be on the <role> page


    Scenario: Steps too short
        Given The employee is on the Defect Reporter Page 
        When The employee selects todays date 
        When The employee types in "Description" with
            """
            Users are able to create multiple accounts using the same username but
            with a different password.
            """
        When The employee types in "Steps" with 
            """
            meh
            """
        When The employee selects high priority 
        When The employee selects low severity 
        When The employee clicks the report button 
        Then No confirmation dialog appears

    Scenario: Description too short
        Given The employee is on the Defect Reporter Page 
        When The employee selects todays date 
        When The employee types in "Description" with
            """
            meh
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
        Then No confirmation dialog appears

    Scenario: No Date Selected
        Given The employee is on the Defect Reporter Page 
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
        Then No confirmation dialog appears