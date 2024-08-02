@regression
  Feature: the user is clicking on the sliders


    Scenario: first slider is clickable on home page
      Given the user clicks on the first slider in the home page
      Then the user should be redirected to a new page according to the first slider



      Scenario: second slider is clickable on home page
        Given the user clicks on the second slider in the home page
        Then the user should be redirected to a new page according to the second slider