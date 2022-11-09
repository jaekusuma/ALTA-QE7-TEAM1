Feature: Delete Comments Feature test

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

