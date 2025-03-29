@ui @regression
Feature: User adds products to Cart and selects quantity

  Background:
    Given user clicks consent button verifies home page is visible

  Scenario: User adds a product to the cart with a specified quantity
    When user clicks on View Product for the product, product index '1'
    Then user verifies product index '1' details are visible on the Product Page
    When user sets product quantity to '4'
    And user clicks Add to Cart button in Product page
    And user clicks View Cart button on the modal form
    Then user verifies that the product quantity in the cart is '4'

  @recommendedProduct
  Scenario: User adds a product from recommended items and user verifies product details are displayed
    When user navigates to page bottom and finds 'RECOMMENDED ITEMS'
    And user hovers to product and adds a product '1' from Recommended Items
    And user clicks View Cart button on the modal form
    Then user verifies the Cart Page is displayed
    And user verifies added to cart products are visible '1'

