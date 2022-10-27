Feature: Login

    Scenario: Login Correct Username Wrong Password
        Given The employee is on the login page
        When The employee types in g8tor into the username input 
        And The employee types in chomp! into the password input 
        And The employee clicks on the login button 
        Then The employee should see an alert saying they have the wrong password

    Scenario: Login Wrong Username 
        Given The employee is on the login page
        When The employee types in sicEmDawgs into the username input 
        And The employee types in natchamps into the password input 
        And The employee clicks on the login button 
        Then The employee should see an alert saying no user with that username found
        
        