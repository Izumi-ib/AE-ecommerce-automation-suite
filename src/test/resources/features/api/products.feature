@api @regression
Feature: Product Management

  Scenario: GET all products
    When I send a Get method to 'basePath'
    Then I should receive a list of products with status code '200'

  Scenario: POST to all Product List
    When I send a Post method to 'basePath'
    Then I should receive a response code '405'
    And I should get a response message 'This request method is not supported.'


