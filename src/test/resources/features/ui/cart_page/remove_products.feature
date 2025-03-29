@ui @regression
Feature: User removes products from cart

  Background:
    Given user clicks consent button verifies home page is visible

  Scenario: User removes particular products and verifies that product is removed from the cart
    When user hovers over product with index '2' and clicks the Add to Cart button
    And user clicks Continue shopping button
    And user hovers over product with index '5' and clicks the Add to Cart button
    And user clicks Continue shopping button
    And user hovers over product with index '6' and clicks the Add to Cart button
    And user clicks View Cart button on the modal form
    Then user verifies the Cart Page is displayed
    When user removes product index '2' from cart
    And user removes product index '5' from cart
    Then user verifies products length '1' are removed from the cart

