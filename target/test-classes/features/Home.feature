Feature: This feature is use for testing UI of Retail page
@test
  Scenario: Verify user can search a product
    Given User is on retail website
    When User search for "pokemon" product
    And User search for other "webcam" product
    Then The product should be displayed
    Then The sign in button should be present
    Then The cart button should be present
