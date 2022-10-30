Feature: Login
    # Test TC-2
    Scenario: Login Correct Username Wrong Password
        Given The employee is on the login page
        When The employee types "g8tor" into username input
        And The employee types "champ!" into password input
        And The employee clicks on the login button 
        Then The employee should see an alert saying "they have the wrong password"

    # Test TC-3
    Scenario: Login Wrong Username 
        Given The employee is on the login page
        When The employee types "sicEmDawgs" into username input
        And The employee types "natchamps" into password input
        And The employee clicks on the login button 
        Then The employee should see an alert saying "no user with that username found"
    # Test TC-4
    Scenario: Login Blank Username and Blank Password
        Given The employee is on the login page
        When The employee types ' ' into username input
        And The employee types ' ' into password input
        And The employee clicks on the login button 
        Then The employee should see an alert saying "Username not found"

    # Test TC-5
    Scenario: Login Blank Username and Correct Password
        Given The employee is on the login page
        When The employee types ' ' into username input
        And The employee types "champ!" into password input
        And The employee clicks on the login button 
        Then The employee should see an alert saying "Username not found"

    # Test TC-6
    Scenario: Login Correct Username and Blank Password
        Given The employee is on the login page
        When The employee types "g8tor" into username input
        And The employee types ' ' into password input
        And The employee clicks on the login button 
        Then The employee should see an alert saying "they have the wrong password"
    
        