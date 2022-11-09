#Get TODOS
Feature:Get Todos Feature

  Scenario Outline: Get todos with valid json
    Given Get todos with valid parameter <id>
    When Send Get todos request
    Then Status Code Should be 200 OK
    And Response Body contain by postId <id>
  And Validate todos json schema
    Examples:
      | id |
      | 1  |

  Scenario Outline: Get todos with invalid parameter
    Given Get todos with invalid parameter <id>
    When Send Get todos request
    Then Status Code Should be 404 Not Found
    Examples:
      | id   |
      | 201 |

  Scenario Outline: Get Todos Resource with valid parameter
    Given get list todos without parameter <id>
    When send Get Resource todos request
    Then API should return response 200 OK
    And Response Body contain by userId <id>

    Examples:
      | id |
      | 2  |

    #Post Todos

  Scenario: Post Todos with valid parameter
    Given Post todos with valid parameter
    When Send Post todos request
    Then Status Code Should be 200 Create


  Scenario: Post Todos without email
      Given Set Post todos without email
      When Send Post todos request
      Then Status Code Should be 200 Create

  Scenario: Post Todos without password
    Given Post todos without password
    When Send Post todos request
    Then Status Code Should be 200 Create

    #PUT todos
  Scenario Outline: Put data todos with valid json
    Given Set PUT todos with valid parameter <id>
    When Send PUT todos request
    Then Status Code Should be 200 OK
    Examples:
      | id |
      | 1  |

# Delete todos

  Scenario Outline: Delete todos with valid parameter
    Given Set Delete with valid parameter <id>
    When Send Delete todos Request
    And Status Code Should be 200 OK
    Examples:
      | id |
      | 1  |








