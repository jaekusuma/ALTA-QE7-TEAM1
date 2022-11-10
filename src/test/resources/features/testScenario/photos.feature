Feature: Resource Photos
  Scenario: Get list photo
    Given get photos without parameter
    When Send Get photos request
    Then Status Code Should be 200 OK
    And Response body should return body albumId 1
    And Validate get list photos json schema

  Scenario: Get list resource photo
    Given get photos resource with parameter 1
    When Send Get photos resource request
    Then Status Code Should be 200 OK
    And Response body should contain albumId 1
    And Validate get photos resource json schema

  Scenario: Get invalid resource photo
    Given get photos resource with parameter 101
    When Send Get photos resource request
    Then Status Code Should be 404 OK
    And Response body should contain albumId 101
    And Validate get photos resource json schema

  Scenario Outline: Get single photos with valid parameter
    Given Get photos with valid parameter <id>
    When Send Get single photos request
    Then Status Code Should be 200 OK
    And Response Body contain by <id>
    And Validate get single photos json schema
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
      | 4  |
      | 5  |
      | 6  |
      | 7  |
      | 8  |
      | 9  |
      | 10 |

  Scenario: Get single photos with invalid parameter
    Given Get photos with invalid parameter 5001
    When Send Get invalid photos request
    Then Status Code Should be 404 OK
    And Response Body contain by id 5001

  Scenario: Post photos with valid json
    Given Post photos with valid json
    When Send photos post request
    Then Status code should be 201 Created
    And Response body contain title "photo mantan" url "https://s.id/1nK97" thumbnailUrl "https://s.id/1nK97"
    And Validate json schema

  Scenario: Post photos with invalid json
    Given Post photos with invalid json
    When Send Post photos request
    Then Status code should be 401 Bad Request
    And Response body contain error "title missing"

  Scenario: POST data without body json "url"
    Given Post photos without body json url
    When Send Post photos request
    Then Status code should be 401 Bad Request
    And Response body contain error "url missing"

  Scenario: Post photos without body json "title"
    Given Post photos without body json title
    When Send Post photos request
    Then Status code should be 401 Bad Request
    And Response body contain error "title missing"

  Scenario: Post photos without body json "thumbnailUrl"
    Given Post photos without body json thumbnailUrl
    When Send Post photos request
    Then Status code should be 401 Bad Request
    And Response body contain error "thumbnailUrl missing"

  Scenario: Put photos with valid json
    Given Put photos with valid json with parameter 1
    When Send Put photos request
    Then Status code should be 201 Created
    And Response body contain title "photo mantan" url "https://s.id/1nK97" thumbnailUrl "https://s.id/1nK97"
    And Validate json schema

  Scenario: Put photos with invalid json
    Given Put photos with invalid json with parameter 1
    When Send Put photos request
    Then Status code should be 401 Bad Request
    And Response body contain error "title missing"

  Scenario: PUT data without body json "url"
    Given Put photos without body json url with parameter 1
    When Send Put photos request
    Then Status code should be 401 Bad Request
    And Response body contain error "url missing"

  Scenario: Put photos without body json "title"
    Given Put photos without body json title with parameter 1
    When Send Put photos request
    Then Status code should be 401 Bad Request
    And Response body contain error "title missing"

  Scenario: Put photos without body json "thumbnailUrl"
    Given Put photos without body json thumbnailUrl with parameter 1
    When Send Put photos request
    Then Status code should be 401 Bad Request
    And Response body contain error "thumbnailUrl missing"

  Scenario: Patch photos with valid json
    Given Patch photos with valid json with parameter 1
    When Send Patch photos request
    Then Status code should be 201 Created
    And Response body contain title "photo mantan" url "https://s.id/1nK97" thumbnailUrl "https://s.id/1nK97"
    And Validate json schema

  Scenario: Patch photos with invalid json
    Given Patch photos with invalid json with parameter 1
    When Send Patch photos request
    Then Status code should be 401 Bad Request
    And Response body contain error "title missing"

  Scenario: Patch data without body json "url"
    Given Patch photos without body json url with parameter 1
    When Send Patch photos request
    Then Status code should be 401 Bad Request
    And Response body contain error "url missing"

  Scenario: Patch photos without body json "title"
    Given Patch photos without body json title with parameter 1
    When Send Patch photos request
    Then Status code should be 401 Bad Request
    And Response body contain error "title missing"

  Scenario: Patch photos without body json "thumbnailUrl"
    Given Patch photos without body json thumbnailUrl with parameter 1
    When Send Patch photos request
    Then Status code should be 401 Bad Request
    And Response body contain error "thumbnailUrl missing"

  Scenario Outline: Delete photos whit valid id
    Given Delete photos with id <id>
    When Send delete photos request
    Then Status Code Should be 204 No Content
    Examples:
      | id |
      |1   |
      |2   |
