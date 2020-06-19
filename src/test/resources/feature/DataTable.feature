Feature: Login with help of DataTables

  @AB2
  Scenario: Login with correct credentials
  Given user navigated to website
  Then Enter userid and password
  | Name | SurName |
  | Ajeet1 | Yadawa1|
  | Ajeet2 | Yadawa2|
  | Ajeet3 | Yadawa3|
  | Ajeet4 | Yadawa4|
  Then User successfully login into Application


  @AB3
  Scenario Outline: Login with correct credentials
    Given user navigated to website
    Then <userid> and <password>
    Then User successfully login into Application

    Examples:
    |userid|password|
    |exampleuserID|ExamplePassword|