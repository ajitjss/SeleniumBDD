Feature: Test Login feature with multiple credentials

  @AB1
  Scenario Outline: Test Newtour website with Multiple credenetials
    Given Open the firefox and open application
    When user enter "<username>" and "<password>"
     Then user should be successfully login into Application

    Examples:
    |username|password|
    |mercury |mercury |
    |mercury |mercury |
    |mercury |mercury |
    |mercury |mercury |


  @AB2
  Scenario: Test Newtour website with Multiple credenetials
    Given Open the firefox and open application
    When user enter "mercury" and "mercury"
    Then user should be successfully login into Application
