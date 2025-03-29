@api @regression
Feature: Product Management

  Scenario: Get all products
    When I send a Get method to 'basePath'
    Then I should receive a list of products with status code '200'
