@regression
Feature: The user should be able to change the currency

 @Smoke
Scenario: The user could change the currency
      Given user select the euro currency from the dropDownList from top left of the home page
      Then the currency should be changed in the prices of the page