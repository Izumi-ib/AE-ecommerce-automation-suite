@api @regression
Feature: Product Management

  Scenario: GET all products
    When I send a Get method to 'productsPath'
    Then I should receive a list of products with status code '200'

  Scenario: POST to all Product List
    When I send a Post method to 'productsPath'
    Then I should receive a response code '405'
    And the response body should contain 'message' with message 'This request method is not supported.'


