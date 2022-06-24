Feature: Update an actor
  As a user I would like to update an existing actor in my table

  Scenario: I successfully updated an actor from my table
    Given I have the new actor information
    When I input the data into the database to update
    Then I get the success return for updating an actor