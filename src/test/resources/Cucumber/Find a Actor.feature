Feature: Find an actor
  As a user I would like to find an existing actor in my table

  Scenario: I successfully find an actor from my table
    Given I have the actor id of the actor
    When I input the data into the database to get
    Then I get a return of the correct actor