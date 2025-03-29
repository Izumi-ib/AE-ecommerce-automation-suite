@ui @regression
  Feature: User registration and account deletion

    Background:
      Given user clicks consent button verifies home page is visible
      When user clicks SignUpLogin button and navigates to the signup page
      Then user validates new user 'New User Signup!' title
      When user enters name and email and clicks Signup button

    @creation
    Scenario: User successfully registers and receives confirmation message
      Then user validates account information 'ENTER ACCOUNT INFORMATION' title
      When user fills in personal details 'Mr', 'name', 'email', password, '19/3/1989'
      And user selects checkbox 'Sign up for our newsletter!' and checkbox 'Receive special offers from our partners!'
      And user fills details 'Arlen', 'StraightSword', 'Birds', 'Address', 'Address2', 'United States', 'State', 'City', '12354', '465468454895600' And user clicks Create account button
      Then user verifies account created 'ACCOUNT CREATED!' message
      When user clicks Continue button
      Then user verifies 'Logged in as ' username is visible

    @deletion
    Scenario: User successfully deletes account and receives confirmation message
      Then user validates account information 'ENTER ACCOUNT INFORMATION' title
      When user enters email address 'userEmail' and password 'password'
      And user clicks login button
      Then user verifies 'Logged in as ' username is visible
      When user clicks Delete Account button
      Then user verifies account deleted 'ACCOUNT DELETED!' message
      And user clicks Continue button

    Scenario: User successfully registers, deletes account, and receives confirmation message
      Then user validates account information 'ENTER ACCOUNT INFORMATION' title
      When user fills in personal details 'Mr', 'name', 'email', password, '19/3/1989'
      And user selects checkbox 'Sign up for our newsletter!' and checkbox 'Receive special offers from our partners!'
      And user fills details 'Arlen', 'StraightSword', 'Birds', 'Address', 'Address2', 'United States', 'State', 'City', '12354', '465468454895600' And user clicks Create account button
      Then user verifies account created 'ACCOUNT CREATED!' message
      When user clicks Continue button
      Then user verifies 'Logged in as ' username is visible
      When user clicks Delete Account button
      Then user verifies account deleted 'ACCOUNT DELETED!' message
      When clicks Continue button
      Then user redirected to the home page

    @existEmail
    Scenario: User registers by existing email
      Then user verifies email already exist message 'Email Address already exist!' is visible