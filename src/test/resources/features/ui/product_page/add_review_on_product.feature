@ui @regression
Feature: User adds new review on product

  Background:
    Given user clicks consent button verifies home page is visible

  Scenario:
    When user navigates to Products page
    Then user verifies products section title 'ALL PRODUCTS' is visible
    When user clicks on View Product for the product, product index '4'
    Then user verifies review title 'WRITE YOUR REVIEW' on the Product page
    When user enters name 'username', email 'loginUserEmail', review message 'First review' and user clicks submit button
    Then user verifies success review message 'Thank you for your review.'