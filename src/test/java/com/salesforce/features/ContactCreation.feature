Feature: Contact Creation

  Background:
    Given user opens salesforce login url
    When user enters valid credentials
    Then user click on login button
    Then user should be logged in successfully
    And User chooses "Sales" app from app launcher
@test
    Scenario: Contact Creation
      Given User clicks on "Contacts" Tab
      When User clicks on New button in "Contacts" tab
      Then User completes fields on new contact
      And user clicks on Save button in "Contacts" tab

