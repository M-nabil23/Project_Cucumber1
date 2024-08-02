@regression
Feature: The user should be able to change the currency


Scenario: The user could change the currency
      When user select the euro currency from the dropDownList from top left of the home page
      Then the currency should be changed in the prices of the page