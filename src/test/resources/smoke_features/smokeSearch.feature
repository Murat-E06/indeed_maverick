Feature: User wants to search single job

  Background:
    Given user opens indeed home page
    Then user clicks all unnecessary visible windows


  Scenario Outline: User can successfully search a single job
    When user inputs "<job>" to What and "<city>" to Where boxes
    And user clicks Find jobs button
    Then user sees "<job>" and "<city>" results successfully

    Examples:
      | job       | city      |
      | QA | Ankara |





