Feature: Testing the internet heroku app website

  Background:
    Given I navigate to the homepage
    Then the homepage should be loaded


  Scenario: A/B Testing page
    When I click on the "A/B Testing" link
    Then the A/B page should be loaded

  Scenario: Basic Auth page
    When I enter the login credentials
    Then the Basic Auth page should be loaded

  Scenario: Checkboxes page
    When I click on the "Checkboxes" link
    Then the last checkbox is checked