@ui @regression
Feature: User subscribes to updates of the Website

  Background:
    Given user clicks consent button verifies home page is visible

  Scenario: User enters email address and verifies subscribed message
    When user scrolls down to footer
    Then user verifies 'SUBSCRIPTION' title
    When user enters email address 'userEmail' to Subscription form
    And user clicks arrow button
    Then user verifies subscription success message 'You have been successfully subscribed!' is visible
