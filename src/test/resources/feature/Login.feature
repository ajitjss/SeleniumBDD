Feature: Login Feature
  @AB4
Scenario: Verification of Reset Button on Login Page
Given Open the firefox and open application
When enter the Username and Password
Then reset the credentials
@AB5
Scenario: Verification of Login Functionality
Given Open the firefox and open application
When user enter <username> and <password>
Then user should be successfully login into Application
