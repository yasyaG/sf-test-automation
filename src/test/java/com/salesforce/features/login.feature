Feature: Test Salesforce login feature

  Scenario: Verify if user is able to login to Salesforce with valid credentials
    Given user opens salesforce login url
    When user enters valid credentials
    And user click on login button
    Then user should be logged in successfully

  Scenario: Verify error is displayed when invalid credentials are entered
    Given user opens salesforce login url
    When user enters invalid credentials
    And user click on login button
    Then user should see an error message