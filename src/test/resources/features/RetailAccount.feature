Feature: Retail Application Account Feature

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email '1aaiqbal@gmail.com' and password 'Deena@112233'
    And User click on login button
    And User should be logged in into Account

  @smokeTest
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'AbdulAhad' Phone '1011228855' and email 'banooristani@gmail.com'
    And User click on Update button
    Then User profile information should be updated
