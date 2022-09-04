Feature: User wants to search remote  job list

  Background:
    Given user opens indeed home page
    Then user clicks all unnecessary visible windows

  @local
  Scenario Outline: User can successfully search a single job
    Given user opens indeed home page
    When user inputs "<job>" to What and "<city>" to Where boxes
    And user clicks Find jobs button
    Then user puts the list of local jobs to excel

    Examples:
      | job       | city   |
      | QA | Ankara |

