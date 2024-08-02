@regression
  Feature: Trying the Contact us form

    @smoke
    Scenario: The user is trying the Contact us form with Valid Data
      Given The user go to the Contact us page
      When  The user enter his name
      And   The user enter his email
      And   The user enter his Enquiry
      Then  The user should be able to send the msg Successfully