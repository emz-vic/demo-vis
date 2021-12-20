Feature: Test UI for input and date picker

  @UiTest
  Scenario: Test input
    Given I navigate to automation practice site
    When I navigate to Alert category
    And I click to display input alert
    And I enter my name in the input
    Then my name appears in the message

  @UiTest
  Scenario: Test datepicker
    Given I navigate to automation practice site
    When I navigate to Datepicker category
    And I go to format date option
    And I select today's date and ISO 8601 format
    Then the date is formatted accordingly