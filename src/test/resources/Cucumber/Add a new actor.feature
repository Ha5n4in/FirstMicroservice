Feature: Add a new actor
  As a user I would like to add a new actor into my table

  Scenario: I successfully add an actor into my table
    Given I have the actors information
    When I input the data into the database to add
    Then I get the success return for adding actor
