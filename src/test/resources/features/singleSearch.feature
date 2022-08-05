Feature: User wants to search single job
  @wip
  Scenario: User can successfully search a single job
    Given user opens indeed home page
    When user inputs "qa tester" to What and "Liverpool" to Where boxes
    And user clicks Find jobs button
    Then user sees "qa tester" and "Liverpool" results successfully
