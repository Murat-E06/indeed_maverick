Feature: User wants to search  job list

  Background:
    Given user opens indeed home page
    Then user clicks all unnecessary visible windows


  Scenario Outline: User can successfully search a single job
    Given user opens indeed home page
    When user inputs "<job>" to What and "<city>" to Where boxes
    And user clicks Find jobs button
    And user selects 5 miles from dropdown
    Then user gets the list of jobs

    Examples:
      | job       | city      |
      | qa tester | Liverpool |


  Scenario Outline: User can successfully search a single job
    Given user opens indeed home page
    When user inputs "<job>" to What and "<city>" to Where boxes
    And user clicks Find jobs button
    And user selects 50 miles from dropdown
    Then user clicks pages number buttons and get all list of jobs

    Examples:
      | job       | city      |
      | qa tester | Liverpool |

  @wip
    Scenario Outline: User can successfully store jobs in Map format
    Given user opens indeed home page
    When user inputs "<job>" to What and "<city>" to Where boxes
    And user clicks Find jobs button
    And user gets the list of jobs
    Then user gets the list of the jobs in Map format


    Examples:
      | job       | city   |
      | QA        | Ankara |


  Scenario Outline: User can successfully store jobs in Map format
    Given user opens indeed home page
    When user inputs "<job>" to What and "<city>" to Where boxes
    And user clicks Find jobs button
    And user gets the list of jobs
    And user gets the list of the jobs in Map format
    Then user gets the list of the job from data base


    Examples:
      | job       | city   |
      | qa tester | London |


  Scenario: User can successfully store jobs in Map format
    Given user reads the list of the job from data base


  Scenario Outline: User can successfully store jobs in Map format
    Given user opens indeed home page
    When user inputs "<job>" to What and "<city>" to Where boxes
    And user clicks Find jobs button
    And user gets the list of jobs
    And user gets the list of the jobs in Map format
    And user reads the list of the job from data base
    Then user verifies jobs from db is in the ui list

    Examples:
      | job       | city   |
      | SENIOR QA | London |
