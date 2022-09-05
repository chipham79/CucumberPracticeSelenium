Feature: Searching new cars
  In order to search new cars
  As a user
  I have to navigate to carwale.com

  Scenario:
    Given user navigate to carwale website
    When user mouseover to new cars
    When user clicks on Findnewcars
    And user clicks on Toyota car
    Then user validates title car as Toyota Cars
