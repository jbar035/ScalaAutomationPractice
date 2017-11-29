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

  Scenario: Javascript alerts page
    Given I click on the "JavaScript Alerts" link
    Then the Javascript alert page should be loaded
    And I click the second button on the page
    When I accept the confirmation alert
    Then the result should be "You clicked: Ok"

  Scenario: Dropdown page
    Given I click on the "Dropdown" link
    When I select dropdown Option 1
    Then the selected value should be displayed

  Scenario: Screenshot fails
    When I fail an assertion on the page header
#    Then output a failure message to the terminal
#    Then I capture a timestamped screen shot in the current working directory

  Scenario: Dynamic Loading page
    Given I click on the "Dynamic Loading" link
    Then the Dynamically Loaded Page Elements page should be loaded
    When I click on "Example 1: Element on page that is hidden"
    And I click the start button
    Then I wait until the message is displayed


