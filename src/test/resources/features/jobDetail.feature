Feature: User wants to search  job list

  Background:
    Given user opens indeed home page
    Then user clicks all unnecessary visible windows

@wip
  Scenario Outline: User can successfully search a single job
    When user inputs "<job>" to What and "<city>" to Where boxes
    And user clicks Find jobs button
    Then user gets the detail of the first job

    Examples:
      | job       | city      |
      | qa tester | Liverpool |