Feature: User registration
  @smoke
  Scenario Outline: check user registration successfully or not
    Given user has the api '<path>'
    When user hit '<name>' and '<job>'
    And call the api with body
    Then it will return created date data

    Examples:
    |path |name      |job|
    |users| Manotosh |qa|