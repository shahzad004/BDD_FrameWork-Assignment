@SMOKE
Feature: SearchBar Feature

  Scenario: Search for something in Search bar
    Given I am on flipkart
    And I will click on search Bar
    And I will search for "Mobile"
    Then I will have Mobiles list
