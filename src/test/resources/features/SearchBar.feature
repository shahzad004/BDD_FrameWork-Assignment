Feature: SearchBar Feature

  Scenario Outline: Search for something in Search bar
    Given I am on flipkart
    And I will click on search Bar
    And I will search for "<product>"
    Then I will have Mobiles list


    Examples:
      | product      |
      | Mobile Phone |
      | Laptop       |
      | Headphones   |
      | Shoes        |
      | Refrigerator |