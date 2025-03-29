@ui @regression
  Feature: User fills Contact us form
    Background:
      Given user clicks consent button verifies home page is visible

    Scenario: User successfully fills the form and navigates to home page
      When user navigates to the Contact Us page
      Then user verifies that the message 'GET IN TOUCH' is visible
      When user fills out the Contact Us form with 'Arlen', 't79916769@gmail.com', 'ETC', 'sdasdawdasdasd', 'C:\\Users\\oldma\\OneDrive\\Pictures\\Pictures'
      And user submits the Contact Us form
      And user accepts the alert
      Then user verifies Contact Us submission success message 'Success! Your details have been submitted successfully.' is visible
      When user navigates back to the Home page
      Then user verifies that the Home page URL is correct