@ui @regression
Feature: User Login functionality

  Background:
    Given user clicks consent button verifies home page is visible
    When user clicks SignUpLogin button and navigates to the signup page
    And user should see 'Login to your account' on the login form

  Scenario: User logins (Positive test)
    And user successfully registers
    And user clicks Continue button
    Then user verifies 'Logged in as ' username is visible
    When user clicks logout button
    When user clicks SignUpLogin button and navigates to the signup page
    Then user should see 'Login to your account' on the login form
    When user enters email address 'registerUserEmail' and password 'password'
    And user clicks login button
    Then user verifies 'Logged in as ' username is visible
    When user clicks Delete Account button
    Then user verifies account deleted 'ACCOUNT DELETED!' message
    And user clicks Continue button

  Scenario: User logs in to existed account
    And user enters email address 'loginUserEmail' and password 'password'
    And user clicks login button
    Then user verifies 'Logged in as ' username is visible
    And user verifies that the Home page URL is correct

  Scenario: User logs in to existed account and logs out
    And user enters email address 'loginUserEmail' and password 'password'
    And user clicks login button
    Then user verifies 'Logged in as ' username is visible
    And user verifies that the Home page URL is correct
    When user clicks logout button
    Then user navigates to loginPage and should validate page title

    # Negative Test for User Login
  Scenario: User fails login with incorrect email and password
    And user enters email address 'incorrectEmail' and password 'incorrectPassword'
    And user clicks login button
    Then user verifies error message 'Your email or password is incorrect!' is visible

  Scenario: User fails login with incorrect email and correct password
    And user enters email address 'incorrectLoginEmail' and password 'password'
    And user clicks login button
    Then user verifies error message 'Your email or password is incorrect!' is visible

  Scenario: User fails login with correct email and incorrect password
    And user enters email address 'loginUserEmail' and password 'incorrectLoginPassword'
    And user clicks login button
    Then user verifies error message 'Your email or password is incorrect!' is visible
