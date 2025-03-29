@ui @regression
Feature: User adds multiple Products to the Cart

  Background:
    Given user clicks consent button verifies home page is visible

  Scenario: User adds multiple products to the cart and verifies their details
    When user navigates to Products page
    And user hovers over product with index '1' and clicks the Add to Cart button
    And user clicks Continue shopping button
    And user hovers over product with index '2' and clicks the Add to Cart button
    And user clicks View Cart button on the modal form
    Then user verifies that the total number of products in the cart is '2'
    And user verifies that each product has the prices 'Price', quantity 'Quantity' and total price 'TotalPrice'

