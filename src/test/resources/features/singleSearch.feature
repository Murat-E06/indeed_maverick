Feature: User wants to search single job

  Background:
    Given user opens indeed home page
    Then user clicks all unnecessary visible windows

  Scenario: User can successfully search a single job
    When user inputs "qa tester" to What and "Liverpool" to Where boxes
    And user clicks Find jobs button
    Then user sees "qa tester" and "Liverpool" results successfully

  Scenario Outline: User can successfully search a single job
    When user inputs "<job>" to What and "<city>" to Where boxes
    And user clicks Find jobs button
    Then user sees "<job>" and "<city>" results successfully

    Examples:
      | job       | city      |
      | qa tester | Liverpool |

  Scenario Outline: User can successfully search a single job
    When user inputs "<job>" to What and "<city>" to Where boxes
    And user clicks Find jobs button
    And user selects 50 miles from dropdown
    Then user sees number of job results successfully

    Examples:
      | job       | city      |
      | qa tester | Liverpool |


