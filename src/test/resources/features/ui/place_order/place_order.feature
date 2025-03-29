@ui @regression @placeOrder
Feature: User places an order

  Background:
    Given user clicks consent button verifies home page is visible

  Scenario: User Registers while Checkout
    When user hovers over product with index '1' and clicks the Add to Cart button
    And user clicks View Cart button on the modal form
    Then user verifies the Cart Page is displayed
    When user proceeds to checkout
    And user clicks Register and Login button on the modal
    And user enters name and email and clicks Signup button
    And user fills in personal details 'Mr', 'name', 'email', password, '19/3/1989'
    And user selects checkbox 'Sign up for our newsletter!' and checkbox 'Receive special offers from our partners!'
    And user fills details 'Arlen', 'StraightSword', 'Birds', 'Address', 'Address2', 'United States', 'State', 'City', '12354', '465468454895600' And user clicks Create account button
    Then user verifies account created 'ACCOUNT CREATED!' message
    And user clicks Continue button
    And user verifies 'Logged in as ' username is visible
    When user navigates to CartPage
    And user proceeds to checkout
    Then user verifies address details and reviews the order
    When user adds a comment 'First message' and places the order
    And user enters payment details Name on Card 'ARLEN STRAIGHTSWORD', Card number '456445647895445', CVC '752', Expiration Date '02/32'
    And user confirms the payment
    Then user verifies order message 'Congratulations! Your order has been confirmed!' is visible
    When user clicks Delete Account button
    Then user verifies account deleted 'ACCOUNT DELETED!' message
    When user clicks Continue button
    Then user verifies that the Home page URL is correct

  Scenario: User registers before checkout
    When user clicks SignUpLogin button and navigates to the signup page
    And user enters name and email and clicks Signup button
    And user fills in personal details 'Mr', 'name', 'email', password, '19/3/1989'
    And user selects checkbox 'Sign up for our newsletter!' and checkbox 'Receive special offers from our partners!'
    And user fills details 'Arlen', 'StraightSword', 'Birds', 'Address', 'Address2', 'United States', 'State', 'City', '12354', '465468454895600' And user clicks Create account button
    Then user verifies account created 'ACCOUNT CREATED!' message
    And user clicks Continue button
    And user verifies 'Logged in as ' username is visible
    When user hovers over product with index '5' and clicks the Add to Cart button
    And user clicks View Cart button on the modal form
    Then user verifies the Cart Page is displayed
    When user proceeds to checkout
    Then user verifies address details and reviews the order
    When user adds a comment 'French fries' and places the order
    And user enters payment details Name on Card 'ARLEN STRAIGHTSWORD', Card number '456445647895445', CVC '752', Expiration Date '02/32'
    And user confirms the payment
    Then user verifies order message 'Congratulations! Your order has been confirmed!' is visible
    When user clicks Delete Account button
    And user verifies account deleted 'ACCOUNT DELETED!' message
    When user clicks Continue button
    Then user verifies that the Home page URL is correct

  Scenario: User logins before checkout
    When user clicks SignUpLogin button and navigates to the signup page
    And user enters email address 'userEmail' and password 'password'
    And user clicks login button
    Then user verifies 'Logged in as ' username is visible
    When user hovers over product with index '5' and clicks the Add to Cart button
    And user clicks View Cart button on the modal form
    Then user verifies the Cart Page is displayed
    When user proceeds to checkout
    Then user verifies address details and reviews the order
    When user adds a comment 'French fries' and places the order
    And user enters payment details Name on Card 'ARLEN STRAIGHTSWORD', Card number '456445647895445', CVC '752', Expiration Date '02/32'
    And user confirms the payment
    Then user verifies order message 'Congratulations! Your order has been confirmed!' is visible
    When user clicks Delete Account button
    And user verifies account deleted 'ACCOUNT DELETED!' message
    When user clicks Continue button
    Then user verifies that the Home page URL is correct

  @checkAddress
  Scenario Outline: User registers, proceeds to checkout, and verifies address consistency
    When user clicks SignUpLogin button and navigates to the signup page
    And user enters name and email and clicks Signup button
    And user fills in personal details '<gender>', 'name', 'email', password, '19/3/1989'
    And user selects checkbox 'Sign up for our newsletter!' and checkbox 'Receive special offers from our partners!'
    And user fills details '<userName>', '<userSurname>', '<company>', '<address1>', '<address2>', '<country>', '<state>', '<city>', '<zipcode>', '<phoneNumber>' And user clicks Create account button
    Then user verifies account created 'ACCOUNT CREATED!' message
    And user clicks Continue button
    And user verifies 'Logged in as ' username is visible

    When user hovers over product with index '5' and clicks the Add to Cart button
    And user clicks View Cart button on the modal form
    Then user verifies the Cart Page is displayed

    When user proceeds to checkout
    Then user verifies delivery address is same as registered '<gender> <userName> <userSurname>', '<company>', '<address1>', '<address2>', '<city> <state> <zipcode>', '<country>' '<phoneNumber>'
    And user verifies billing address is same as registered '<gender> <userName> <userSurname>', '<company>', '<address1>', '<address2>', '<city> <state> <zipcode>', '<country>' '<phoneNumber>'

    When user clicks Delete Account button
    And user verifies account deleted 'ACCOUNT DELETED!' message
    When user clicks Continue button
    Then user verifies that the Home page URL is correct

    Examples:
      | gender | userName | userSurname   | company | address1 | address2 | country       | state | city | zipcode | phoneNumber     |
      | Mr.    | Arlen    | StraightSword | Birds   | Address  | Address2 | United States | State | City | 12354   | 465468454895600 |

  @a
  Scenario Outline: User adds a products, registers, pays for the order and downloads an invoice
    When user hovers over product with index '1' and clicks the Add to Cart button
    And user clicks View Cart button on the modal form
    Then user verifies the Cart Page is displayed
    When user proceeds to checkout

    And user clicks Register and Login button on the modal
    And user enters name and email and clicks Signup button
    And user fills in personal details '<gender>', 'name', 'email', password, '19/3/1989'
    And user selects checkbox 'Sign up for our newsletter!' and checkbox 'Receive special offers from our partners!'
    And user fills details 'Arlen', 'StraightSword', 'Birds', 'Address', 'Address2', 'United States', 'State', 'City', '12354', '465468454895600' And user clicks Create account button
    Then user verifies account created 'ACCOUNT CREATED!' message
    And user clicks Continue button
    And user verifies 'Logged in as ' username is visible

    When user navigates to CartPage
    And user proceeds to checkout
    Then user verifies delivery address is same as registered '<gender> <userName> <userSurname>', '<company>', '<address1>', '<address2>', '<city> <state> <zipcode>', '<country>' '<phoneNumber>'
    And user verifies billing address is same as registered '<gender> <userName> <userSurname>', '<company>', '<address1>', '<address2>', '<city> <state> <zipcode>', '<country>' '<phoneNumber>'
    When user adds a comment 'Place order' and places the order
    And user enters payment details Name on Card 'ARLEN STRAIGHTSWORD', Card number '456445647895445', CVC '752', Expiration Date '02/32'
    And user confirms the payment

    Then user verifies order message 'Congratulations! Your order has been confirmed!' is visible
    When user clicks download invoice button and verifies invoice was downloaded
    When user clicks Continue button in Order Placed page
    And user clicks Delete Account button
    Then user verifies account deleted 'ACCOUNT DELETED!' message
    When user clicks Continue button
    Then user verifies that the Home page URL is correct

    Examples:
      | gender | userName | userSurname   | company | address1 | address2 | country       | state | city | zipcode | phoneNumber     |
      | Mr.    | Arlen    | StraightSword | Birds   | Address  | Address2 | United States | State | City | 12354   | 465468454895600 |






