@api @regression

Feature: Brands Management

  Scenario: Get all Brands
    When I send a Get method to 'brandsPath'
    Then I should receive a list of products with status code '200'
#    And the response should have Content-Type 'application/json'

  Scenario: POST to all Brands List
    When I send a Post method to 'brandsPath'
    Then I should receive a response code '405'
    And the response body should contain 'message' with message 'This request method is not supported.'