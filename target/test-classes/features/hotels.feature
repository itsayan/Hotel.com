@regression @hotel
Feature: Hotel ratings and distance Verification

  Background:
    Given I am on Hotel.com Homepage
    And I proceed to search and flight page
    And I enter New York into origin textfield
    And I enter Orlando into destination textfield
    And I enter 05/01/2019 into departure datefield
    And I enter 05/15/2019 into returning datefield
    Then I proceed to result page



@hotel-1
Scenario Outline: Verify user can only view the result by selected property class
  Given I am on default locations search result screen
  When  I select <stars> from property class
  Then  I verify system displays only <stars> hotels on search result

Examples:
| stars   |
| 5 stars |
| 4 stars |
| 3 stars |


@hotel-2
Scenario: List of all of hotel within 10 miles radius of airport or downtown
  Given I am on default locations search result screen
  Then  I verify system displays all hotels within 10 miles radius of airport
  And   I verify Hilton Hotel is within radius