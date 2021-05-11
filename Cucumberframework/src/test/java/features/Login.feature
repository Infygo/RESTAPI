 Feature: Application Login 


Scenario: Homepage default login with valid username password 
Given User is on Net banking landing page 
When  User login into application with "Joe" and password "1234"
Then  Home page is populated 
And   Card displayed are "true"


Scenario: Homepage default login with invalid username password
Given User is on Net banking landing page 
When  User login into application with "John" and password "4321"
Then  Home page is populated 
And   Card displayed are "false"