@ui @regression
Feature: User Logout

  Background:
    Given user clicks consent button verifies home page is visible
    When user clicks SignUpLogin button and navigates to the signup page

  Scenario: User successfully registers and logs out
    And user successfully registers
    And user clicks Continue button
    Then user verifies 'Logged in as ' username is visible
    When user clicks logout button
    Then user navigates to loginPage and should validate page title
    When user enters email address 'registerUserEmail' and password 'password'
    And user clicks login button
    When user successfully deletes the account
    Then user verifies that the Home page URL is correct

  Scenario: User successfully logs in and logs out
    When user enters email address 'loginUserEmail' and password 'password'
    And user clicks login button
    Then user verifies 'Logged in as ' username is visible
    When user clicks logout button
    Then user navigates to loginPage and should validate page title


