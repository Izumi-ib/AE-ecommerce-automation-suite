@ui @regression
Feature: User adds multiple Products to the Cart

  Background:
    Given user clicks consent button verifies home page is visible

  Scenario: User adds multiple products to the cart and verifies their details
    When user navigates to Products page
    And user hovers over product with index '1,2' and clicks the Add to Cart button
    And user clicks View Cart button on the modal form
    Then user verifies that the total number of products in the cart is '2'
    And user verifies that each product has the prices 'Rs. 500, Rs. 400', quantity '1, 1' and total price 'Rs. 500, Rs. 400'

  Scenario: User adds a single product and changes its quantity in the cart
    When user navigates to Products page
    And user clicks on View Product for the product, product index '3'
    And user sets product quantity to '3'
    And user clicks Add to Cart button in Product page
    And user clicks View Cart button on the modal form
    Then user verifies that the total number of products in the cart is '1'
    Then user verifies that each product has the prices 'Rs. 1000', quantity '3' and total price 'Rs. 3000'


