Feature: User wants to search remote  job list

  Background:
    Given user opens indeed home page
    Then user clicks all unnecessary visible windows

@remote
  Scenario Outline: User can successfully search a single job
    Given user opens indeed home page
    When user inputs "<job>" to What box
    And user clicks Find jobs button
    And user selects remote jobs
    Then user puts the list of jobs to excel

    Examples:
      | job |
      | SDET  |

