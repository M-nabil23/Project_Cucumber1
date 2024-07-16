  @regression
Feature: this feature will allow the guest users to create a new valid accounts


  Background: shared steps for signUp
    Given user go to register page

  @smoke
  # Positive Scenario:
  Scenario: guest user could create valid account

    When user select his gender
    And user enter his first and his last name
    And user select his Date of birth
    And user enter his email
    And user enter his company name
    And user unselect newsLetter
    And user enter his password and  confirm password
    And user click on register Button
    Then new account is created successfully
#    Examples:
#      | round |
#      | 1 |
#      | 2 |
#      | 3 |


  # Negative Scenario
  Scenario: guest user Shouldn't create invalid account

    When user select his gender
    And user enter his first and his last name
    And user select his Date of birth
    And user enter his Invalid email
    And user enter his company name
    And user unselect newsLetter
    And user enter his password and  confirm password
    And user click on register Button
    Then new account is not created