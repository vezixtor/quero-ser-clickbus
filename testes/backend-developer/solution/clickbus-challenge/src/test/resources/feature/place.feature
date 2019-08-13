@Place
Feature: Place's CRUD
  Simple API to manage places (CRUD).
  This API should allow to:

  Scenario: Create a place
    When I try to enter the place data
    Then the service returns a place

  Scenario: Edit a place
    Given 1 pre-existing place record
    When I try to change the place data by key
    Then the service returns a place

  Scenario: Get a specific place
    Given 1 pre-existing place record
    When I try to get the place data by key
    Then the service returns a place

  Scenario: List places and filter them by name
    Given 5 pre-existing place record
    When I check the place list
    Then the service returns a place list

  Scenario: Delete place
    Given 1 pre-existing place record
    When I try to delete the place register by key
    Then the service unregisters place
