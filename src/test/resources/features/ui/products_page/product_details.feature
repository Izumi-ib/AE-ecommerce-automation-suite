@ui @regression
Feature: Product listing and details verification
  Background:
    Given user clicks consent button verifies home page is visible

  Scenario: User successfully navigates to Products page and validates a product details
    When user navigates to Products page
    Then user verifies products section title 'ALL PRODUCTS' is visible
    And user verifies products list is visible
    When user clicks on View Product for the product, product index '0'
    Then user verifies product index '0' details are visible on the Product Page