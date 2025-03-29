@ui @regression
Feature: User Login functionality

  Background:
    Given user clicks consent button verifies home page is visible
    When user clicks SignUpLogin button and navigates to the signup page


  Scenario: User logins (Positive test)
    When user enters name and email and clicks Signup button
    When user fills in personal details 'Mr', 'name', 'email', password, '19/3/1989'
    And user selects checkbox 'Sign up for our newsletter!' and checkbox 'Receive special offers from our partners!'
    And user fills details 'Arlen', 'StraightSword', 'Birds', 'Address', 'Address2', 'United States', 'State', 'City', '12354', '465468454895600' And user clicks Create account button
    When user clicks Continue button
    Then user verifies 'Logged in as ' username is visible
    When user clicks logout button
    When user clicks SignUpLogin button and navigates to the signup page
    Then user should see 'Login to your account' on the login form
    When user enters email address 'userEmail' and password 'password'
    And user clicks login button
    Then user verifies 'Logged in as ' username is visible
    When user clicks Delete Account button
    Then user verifies account deleted 'ACCOUNT DELETED!' message
    And user clicks Continue button

  Scenario: User logins (Negative test)
    When user enters email address 'incorrectEmail' and password 'incorrectPassword'
    And user clicks login button
    Then user verifies error message 'Your email or password is incorrect!' is visible
