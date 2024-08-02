@regression
  Feature: the user tries to logout


    Scenario: The user logs out from his account after registering a new account
      Given  The user go to signup page
      And    The user register a new account
      When   The user logout by clicking on the logout Button from header
      Then   The user should be logout Successfully
