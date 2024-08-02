@regression
Feature: Login functionality


  Scenario: user could login with Valid account
    Given user click on login button
    And user enter his email in login Page
    And user enter his password in Login Page
    And user click on loginButton in Login Page
    Then user Login successfully



  Scenario: user couldn't use invalid data to login
    Given user click on login button
    Then user enter his invalid email in login Page
    And user enter his password in Login Page
    And user click on loginButton in Login Page
    Then user gets an error msg and not being able to login