@StartCRM
Feature: Person Type Customer CRUD Feature

  Background: The user is logged in
    Given the user is logged in
    And the user is on the CRM home page


  Scenario: Create a company
    Given the user is on the create a new company page
    When the user enters the company details
    And the user clicks on the save button
    Then the company should be created successfully

