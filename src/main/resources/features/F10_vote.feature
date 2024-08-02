@regression
  Feature: trying the vote functionality


    Scenario: The Logged in user tries the vote functionality
      Given The user should login first
      When  The user Selects on the vote options
      And   The user clicks on vote Button
      Then  The user should gets the results and successfully vote




    Scenario: The Guest user tries the vote functionality
      When  The Guest user Selects on the vote options
      And   The user clicks on vote Button
      Then  The user should not gets results and get validation msg


    Scenario: The Guest user tries the vote functionality

      When     The Guest user clicks on vote Button
      Then     The user should not gets results and get Alert msg