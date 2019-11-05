@web @regression @homework
Feature: Homework

  Background:
    Given I am on home page

  @homework-1
  Scenario Outline: Verify invalid login's for multiple users.
    When I enter Huma into firstname text fields on home screen
    And I enter Asif into lastname text fields on home screen
    And I enter <InvalidEmail> into mobile number text fields on home screen
    And I click on new password field on home screen
    And I click on email mobile field on home screen
    Then I verify invalid email error message on home screen
    Examples:
   | InvalidEmail |
   | plainaddress                    |
   | #@%^%#$@#$@#.com                |
   | @example.com                    |
   | Joe Smith <email@example.com>   |
   | email.example.com               |
   | email@example@example.com       |
   | .email@example.com              |
   | email.@example.com              |
   | email..email@example.com        |
   | あいうえお@example.com            |
   | email@example.com (Joe Smith)   |
   | email@example                   |
   | email@-example.com              |
   | email@example.web               |
   | email@111.222.333.44444         |
   | email@example..com              |
   | Abc..123@example.com            |

  @homework-2
  Scenario: Select current month from dropdown
    When I select on birthday dropdown on home screen
    And I click on current month from the dropdown on home screen
    Then I verify october is selected

  @homework-3
 Scenario: verify if month drop down contains duplicate values
    When I select on birthday dropdown on home screen
    Then I verify month is not duplicate

