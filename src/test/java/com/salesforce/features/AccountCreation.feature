Feature: Account Creation

  Background:
    Given user opens salesforce login url
    When user enters valid credentials
    Then user click on login button
    Then user should be logged in successfully
    And User chooses "Sales" app from app launcher

  Scenario Outline: Creation of new Accounts in SF
    Given User clicks on "Accounts" Tab
    When User clicks on New button in "Accounts" tab
    Then User completes mandatory fields "<Account Name>" and "<Rating>"
    And user clicks on Save button in "Account" tab
    Then User verifies account is created

    Examples:
      | Account Name      | Rating |
      | Test Automation 1 | Hot    |
#      | Test Automation 2 | Warm   |
#      | Test Automation 3 | Cold   |

