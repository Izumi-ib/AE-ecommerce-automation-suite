@ui @regression
Feature: User Logout

  Background:
    Given user clicks consent button verifies home page is visible
    When user clicks SignUpLogin button and navigates to the signup page

  Scenario: User successfully registers and logs out
    When user enters name and email and clicks Signup button
    When user fills in personal details 'Mr', 'name', 'email', password, '19/3/1989'
    And user selects checkbox 'Sign up for our newsletter!' and checkbox 'Receive special offers from our partners!'
    And user fills details 'Arlen', 'StraightSword', 'Birds', 'Address', 'Address2', 'United States', 'State', 'City', '12354', '465468454895600' And user clicks Create account button
    When user clicks Continue button
    Then user verifies 'Logged in as ' username is visible
    When user clicks logout button
    Then user navigates to loginPage and should validate page title

  @logout
  Scenario: User successfully logs in and logs out
    When user enters email address 'userEmail' and password 'password'
    And user clicks login button
    Then user verifies 'Logged in as ' username is visible
    When user clicks logout button
    Then user navigates to loginPage and should validate page title

  @logout
  Scenario: User successfully logs in and deletes an account
    When user enters email address 'userEmail' and password 'password'
    And user clicks login button
    Then user verifies 'Logged in as ' username is visible
    When user clicks Delete Account button
    Then user verifies account deleted 'ACCOUNT DELETED!' message
    And user clicks Continue button
