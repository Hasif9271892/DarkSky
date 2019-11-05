@web @regression @hotels
Feature: Hotels Feature

  @hotels-1
  Scenario Outline: Verify room count dropdown
    Given I am on hotels.com home page
    When I select <select_rooms> from drop down
    Then I verify <number_of_room_dropdown> is displayed

    Examples:
      | select_rooms | number_of_room_dropdown |
      | 1            | 1                       |
      | 2            | 2                       |
      | 3            | 3                       |
      | 4            | 4                       |
      | 5            | 5                       |
      | 6            | 6                       |
      | 7            | 7                       |
      | 8            | 8                       |
      | 9+           | 0                       |





   @hotels-2
   Scenario Outline: Verify user can only view the result by selected property class
     Given I am on default locations search result screen
     When I select property class <stars>
     Then I verify system displays only <stars> hotels on search result
     Examples:
       | stars      |
       | 5-star     |
       | 4-star     |
#       | 3-star     |




   @hotels-3
   Scenario: List of all of hotel within 10 miles radius of city center
      Given I am on default locations search result screen
      Then I verify system displays all hotels within 5 miles radius of airport
      And I verify Hilton Hotel is within radius




  @hotels-4
  Scenario: Verify today deal price value
    Given I am on default locations search result screen
    Then I verify today deal is less than $300


