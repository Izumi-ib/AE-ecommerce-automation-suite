@regression @ui @category
Feature: View categorized products

  Background:
    Given user clicks consent button verifies home page is visible

  Scenario Outline: User successfully selects category and validates each category shown correct
    When user chooses category '<category>'
    And user chooses subcategory '<subcategory>'
    Then user should validate subcategory title '<subcategory>'
    When user chooses category '<nextCategory>'
    And user chooses subcategory '<nextSubcategory>'
    Then user should validate subcategory title '<nextSubcategory>'

    Examples:
      | category | subcategory   | nextCategory | nextSubcategory |
      | kids     | Tops & Shirts         | women        | Saree           |
#      | kids     | Tops & Shirts | women        | tops            |
#      | men      | tshirts       | kids         | dress           |
#      | women    | saree         | men          | tshirts         |
#      | women    | dress         | men          | tshirts         |
#      | kids     | Tops & Shirts | men          | jeans           |
#      | men      | jeans         | women        | dress           |
#      | women    | dress         | women        | tops            |

  Scenario: User is in Homepage
    When user verifies that the Home page URL is correct