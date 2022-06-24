Feature: Find a film
  As a user I would like to find an existing film in my table

  Scenario: I successfully find an film from my table
    Given I have the film id of the film
    When I input the film id into the database
    Then I get a return of the correct film