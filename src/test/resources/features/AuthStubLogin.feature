Feature: Use Auth stub to login

  Scenario: Use Auth Stub to login
    Given I am on the GG Sign-in page
    When I login to Agent for Individuals Landing page as a valid client
    Then wait for 3 secs