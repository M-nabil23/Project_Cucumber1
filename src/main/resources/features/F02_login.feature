@regression
Feature: Login functionality

  @smoke
  Scenario: user could login with Valid account
    Given user click on login button
    And user enter his email in login Page
    And user enter his password in Login Page
    And user click on loginButton in Login Page
    Then user Login successfully
