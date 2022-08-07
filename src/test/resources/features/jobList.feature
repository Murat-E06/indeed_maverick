Feature: User wants to search  job list

  Background:
    Given user opens indeed home page
    Then user clicks all unnecessary visible windows

  @wip
  Scenario Outline: User can successfully search a single job
    Given user opens indeed home page
    When user inputs "<job>" to What and "<city>" to Where boxes
    And user clicks Find jobs button
    And user selects 50 miles from dropdown
    Then user gets the list of jobs

    Examples:
      | job       | city      |
      | qa tester | Liverpool |