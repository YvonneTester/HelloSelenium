Feature: Hello First Feature

  Scenario: Navigating project Euler
    Given I am on the homepage
    And There is a menu option Archives
    When I go navigate to Archives
    Then The first item should be Multiples of 3 or 5