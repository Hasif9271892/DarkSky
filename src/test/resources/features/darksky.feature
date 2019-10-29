@web @regression @darksky
Feature: Darksky Feature


    @darksky-1
    Scenario: Verify on register error
      Given I am on register page
      When I click on register button
      Then I verify error message






      @darksky-2
      Scenario: Verify current Temperature should not be greater or less than the Temperature from Daily Timeline
        Given I am on DarkSky home page
        Then I verify current temperature is not greater or less then temps from daily timeline


#


    @darksky-3
    Scenario: Verify individual day temp timeline
      Given I am on DarkSky home page
      When I expand today's timeline
      Then I verify lowest and highest temp is displayed correctly


#
#


    @darksky-4
   Scenario: Verify timeline is displayed in correct format
    Given I am on DarkSky home page
    Then I verify timeline is displayed with two hours incremented

