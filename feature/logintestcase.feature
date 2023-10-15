Feature: Login feature file for test case

@login
Scenario: User should be able to login to the application

Given User is in login page
When User enters email id "prashanthi.skvl@gmail.com"
And User enters password "Test@123"
And User clicks the signin button
Then close application

@errormessage @smoke
Scenario: User should not login with invalid credentials


Given User is in login page
When User enters email id "test345678123@gmail.com"
And User enters password "test@123"
And User clicks the signin button
Then User should see error message on the screen

@parameters
  Scenario Outline: Title of your scenario outline
Given User is in login page
When User enters email id <name>
And User enters password  <password>
And User clicks the signin button
Then close application

    Examples: 
      |name|password|
      |prashanthi.skvl@gmail.com|Test@123|
      |prashanthi.skvl@gmail.com|Test@123|