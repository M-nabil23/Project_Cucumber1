@regression
Feature: the user is using the Search Functionality

  Scenario Outline: the user is searching using the Product's name
    When the user enter the "<product's_name>" in the search textField
    And the user clicks on the search Button
    Then the search result should display the right data "<product's_name>"
    Examples:
      | product's_name |
      |    book        |
      |   laptop       |
      |    nike        |



    Scenario Outline: the user clicks on the product and check its details
      When the user enter the "<Sku_Name>" in the search textField bar
      And  the user clicks on the search Button
      And  the user  clicks on the product in search result
      Then the user should be able to see the product details "<Sku_Name>"
      Examples:
        | Sku_Name   |
        |  OM_HTC_BL |
        |  RB_AVR_SG |