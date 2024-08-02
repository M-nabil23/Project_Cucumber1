@regression
  Feature: make a full purchase


    Scenario: Make a valid purchase for a registered user

      Given add a product to the cart
      And   Go to the cart by clicking on the Cart Tab in header
