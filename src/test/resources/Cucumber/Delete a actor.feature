Feature: Delete an actor
  As a user I would like to delete an existing actor in my table

  Scenario: I successfully delete an actor from my table
    Given I have the actor id
    When I input the data into the database to delete
    Then I get the success return for deleting an actor