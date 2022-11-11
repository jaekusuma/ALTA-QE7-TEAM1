Feature: Comments Feature test

  Scenario: Get List Comments
    Given Get list comments without parameter
    When Send Get list comments request
    Then Status code should be 200 OK
    And Response body page should be 1
    And Validate get list comments json schema

  Scenario Outline: Get Single Comment
    Given Get single comment with parameter <id>
    When Send get single comment request
    Then Status code should be 200 OK
    And Response body page should be postId and id <postId>
    And Validate get single comment json schema
    Examples:
      | id | postId |
      | 1  | 1      |

  Scenario Outline: Get Single Comment Invalid Parameter
    Given Get single comment with invalid parameter <id>
    When Send get single comment request
    Then Status code should be 404 Not Found
    Examples:
      | id  |
      | 501 |

  Scenario Outline: Get Resource Comments
    Given Get resource comments with parameter <id>
    When Send get resource comments request
    Then Status code should be 200 OK
    And Response body page should be postId 1
    And Validate get resource comments json schema
    Examples:
      | id |
      | 1  |

  Scenario Outline: Get Resource Comments Invalid Parameter
    Given Get resource comments with invalid parameter <id>
    When Send get resource comments request
    Then Status code should be 404 Not Found
    Examples:
      | id  |
      | 101 |

#Feature: Post Comments Feature test
  Scenario: Create New Comment
    Given Post create comment with valid json
    When Send post user comments request
    Then Status code should be 201 Created
    And Response body page should contain name "Destn", email "destn@mail" and body "first comment"
    And Validate post new comment json schema

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

#Feature: Put Comments Feature test
  Scenario Outline: Update Comment
    Given Put update comment with valid json with id <id>
    When Send put update comment request
    Then Status code should be 200 OK
    And Response body page should contain name "Destn", email "destn@mail" and body "second comment"
    And Validate put update comment json schema
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

#Feature: Delete Comments Feature test
  Scenario Outline: Delete list comment
    Given Delete list comment with <id>
    When Send delete list comment request
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |

  Scenario Outline: Delete single comment
    Given Delete single comment page with <id>
    When Send delete single comment request
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |
