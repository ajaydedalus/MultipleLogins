@login
Feature: To validate Login functionality of LIMS

  Background: 
    Given User in Login page

  Scenario: Validating the Login page with invalid username and invalid password
    When User enters invalid username and invalid password
		Then Verifying toast message Invalid username and Invalid password
		
  Scenario: Validating the Login page with valid username and invalid password
    When User enters valid username and invalid password
		Then Verifying toast message Invalid username and Invalid password
		
  Scenario: Validating the Login page with invalid username and valid password
    When User enters invalid username and valid password
    Then Verifying toast message Invalid username and Invalid password

  Scenario: Validating the Login page with empty username and valid password
    When User enters empty username and valid password
    Then Verifying toast message Enter the username

  Scenario: Validating the Login page with empty username and invalid password
    When User enters empty username and invalid password
    Then Verifying toast message Enter the username

  Scenario: Validating the Login page with valid username and empty password
    When User enters valid username and empty password
    Then Verifying toast message Enter the password

  Scenario: Validating the Login page with invalid username and empty password
    When User enters invalid username and empty password
    Then Verifying toast message Enter the password

  Scenario: Validating the Login page with empty username and empty password
    When User enters empty username and empty password
    Then Verifying toast message Enter the username

  Scenario: Validating the Login page with valid username and valid password
    When User enters valid username and valid password
		And User confirming that he is home page
