@regression @ui @brands
Feature: User can filter products using the brand filter

  Background:
    Given user clicks consent button verifies home page is visible

  Scenario Outline: User filters products by brand and verifies correct pages
    When user navigates to Products page
    Then user verifies brands that the 'BRANDS' title is visible
    When user selects the brand '<Brand>'
    Then user verifies that they have navigated to the '<Brand>' page
    And user verifies that only brand '<Brand>' products are displayed
    When user selects the brand '<SecondBrand>'
    Then user verifies that they have navigated to the '<SecondBrand>' page
    And user verifies that only brand '<SecondBrand>' products are displayed

    Examples:
      | Brand       | SecondBrand        |
      | Babyhug     | Mast & Harbour     |
      | Polo        | Allen Solly Junior |
      | Kookie Kids | Babyhug            |
      | Madame      | H&M                |

