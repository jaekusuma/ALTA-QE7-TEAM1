Feature: Post Comments Feature test

  Scenario: Create New Comment
    Given Post create comment with valid json
    When Send post user comments request
    Then Status code should be 201 Created
    And Response body page should contain name "Destn", email "destn@mail" and body "first comment"

  Scenario: Create New Comment without Name
    Given Post create new comment with valid json without name
    When Send post user comments request
    Then Status code should be 400 Bad Request

  Scenario: Create New Comment without Email
    Given Post create new comment with valid json without email
    When Send post user comments request
    Then Status code should be 400 Bad Request

  Scenario: Create New Comment without Body
    Given Post create new comment with valid json without body
    When Send post user comments request
    Then Status code should be 400 Bad Request

  Scenario: Create New Comment invalid JSON
    Given Post create new comment with invalid json
    When Send post user comments request
    Then Status code should be 400 Bad Request