@StartCRM
Feature: Person Type Customer CRUD Feature

  Background: The user is logged in
    Given the user is logged in
    And the user is on the CRM home page

  @CreatePerson
  Scenario: Create a person
    Given the user is on the create a new person page
    When the user enters the person details
    And the user clicks on the save button
    Then the person should be created successfully
