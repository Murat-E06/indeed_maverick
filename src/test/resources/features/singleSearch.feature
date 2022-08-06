Feature: User wants to search single job


  Scenario: User can successfully search a single job
    Given user opens indeed home page
    When user inputs "qa tester" to What and "Liverpool" to Where boxes
    And user clicks Find jobs button
    Then user sees "qa tester" and "Liverpool" results successfully

  @wip
  Scenario Outline: User can successfully search a single job
    Given user opens indeed home page
    When user inputs "<job>" to What and "<city>" to Where boxes
    And user clicks Find jobs button
    Then user sees "<job>" and "<city>" results successfully

    Examples:
      | job       | city      |
      | qa tester | Liverpool |
