Feature: Api tests

  @ApiTest
  Scenario: Check post with title "qui est esse" exists
    Given I make a get with title qui est esse
    Then I get all post details

  @ApiTest
  Scenario: Add new user
    Given I send a post with new user details
    Then the user is created

  @ApiTest
  Scenario: Response is under a threshold of milliseconds
    Given I send a post with new user details
    Then the response is under 10 milisecons