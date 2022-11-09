Feature: Put Comments Feature test

  Scenario Outline: Update Comment
    Given Put update comment with valid json with id <id>
    When Send put update comment request
    Then Status code should be 200 OK
    And Response body page should contain name "Destn", email "destn@mail" and body "second comment"
  Examples:
    | id |
    | 1  |

  Scenario Outline: Update Comment without Name
    Given Put update comment with valid json <id> without name
    When Send put update comment request
    Then Status code should be 400 Bad Request
  Examples:
    | id |
    | 1  |

  Scenario Outline: Update Comment without Email
    Given Put update comment with valid json <id> without email
    When Send put update comment request
    Then Status code should be 400 Bad Request
  Examples:
    | id |
    | 1  |

  Scenario Outline: Update Comment without Body
    Given Put update comment with valid json <id> without body
    When Send put update comment request
    Then Status code should be 400 Bad Request
  Examples:
    | id |
    | 1  |

  Scenario Outline: Update Comment invalid JSON
    Given Put update comment with invalid json <id>
    When Send put update comment request
    Then Status code should be 400 Bad Request
  Examples:
    | id |
    | 1  |