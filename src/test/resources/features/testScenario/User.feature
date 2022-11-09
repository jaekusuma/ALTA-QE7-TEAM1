Feature: Get Users Feature
#Get Users
  Scenario Outline: Get Users with valid json
    Given Get Users with valid parameter <id>
    When Send Get Users request
    Then Status Code Should be 200 OK
    And Response Body contain by Id <id>
    And Validate Users json schema
    Examples:
      | id |  |
      | 1  |  |

  Scenario Outline: Get Users with invalid parameter
    Given Get Users with invalid parameter <id>
    When Send Get Users request
    Then Status Code Should be 404 Not Found
    Examples:
      | id |
      | 11 |

  Scenario Outline: Get Users Resource with valid parameter
    Given get list Users without parameter <id>
    When send Get Resource Users request
    Then API should return response 200 OK
    And Response Body contain by userId <id>

    Examples:
      | id |
      | 1  |

    #Post User
  Scenario: Post Users with valid Body
    Given Post Users with valid body
    When Send Post Users request
    Then Status Code Should be 200 Create

  Scenario: Post Users without Body
    Given Set Post Users without body
    When Send Post Users request
    Then Status Code Should be 200 Create

    #PUT USERS
  Scenario: Put data Users with valid json
    Given Set PUT Users with valid parameter
    When Send PUT Users request
    Then Status Code Should be 200 OK

  Scenario Outline: Put data Users with valid json
    Given PUT Users with valid parameter <id>
    Then Send PUT Users request
    And Status Code Should be 200 OK
    Examples:
      | id |
      | 1  |

    #Delete
  Scenario Outline: Delete Users with valid parameter
    Given Set Delete Users with valid parameter <id>
    When Send Delete Users Request
    And Status Code Should be 200 OK
    Examples:
      | id |
      | 1  |
