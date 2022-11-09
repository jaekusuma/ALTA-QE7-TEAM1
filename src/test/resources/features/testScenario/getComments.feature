Feature: Comments Feature test

  Scenario: Get List Comments
    Given Get list comments without parameter
    When Send Get list comments request
    Then Status code should be 200 OK
    And Response body page should be 1

  Scenario Outline: Get Single Comment
    Given Get single comment with parameter <id>
    When Send get single comment request
    Then Status code should be 200 OK
    And Response body page should be postId and id <postId>
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
