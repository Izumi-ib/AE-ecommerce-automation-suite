@ui @regression
Feature: User searches products and verifies all the products are related to search

  Background:
    Given user clicks consent button verifies home page is visible

  Scenario Outline: User navigates to Products Page and verifies all products are related to search
    When user navigates to Products page
    Then user verifies products section title 'ALL PRODUCTS' is visible
    When user enters product name '<productTitle>'
    And user clicks search button
    Then user validates Searched Products title 'SEARCHED PRODUCTS' is visible
    And user verifies all products '<productTitle>' are related to search and visible
    Examples:
      | productTitle |
      | winter top   |

  @search
  Scenario Outline:
    When user navigates to Products page
    Then user verifies products section title 'ALL PRODUCTS' is visible
    When user enters product name '<productTitle>'
    And user clicks search button
    Then user validates Searched Products title 'SEARCHED PRODUCTS' is visible
    And user verifies all products '<productTitle>' are related to search and visible
    When user hovers over product with index '1' and clicks the Add to Cart button
    And user clicks View Cart button on the modal form
    And user clicks SignUpLogin button and navigates to the signup page
    And user navigates to loginPage and should validate page title
    And user enters email address 'userEmail' and password 'password'
    And user navigates to CartPage
    Then user verifies products in the cart related to the searched '<productTitle>'


    Examples:
      | productTitle |
      | winter top   |










