@ui @regression
Feature: User verifies he navigated to Test Cases page
  Background:
    Given user clicks consent button verifies home page is visible

  Scenario: User successfully navigates to Test Cases page
    When user navigates to Test Cases page
    Then user validates Test Cases url and section title 'TEST CASES'