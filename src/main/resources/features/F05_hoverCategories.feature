@regression
  Feature: the user try to hover on one of main categories then click on sub category



    Scenario Outline: the user try to hover on one of main categories then click on sub category
      Given The user hover on the main category
      Then  The user should be see the subCategories Products
      Examples:
        |1  |
        |2  |
