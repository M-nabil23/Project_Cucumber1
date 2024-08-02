@regression
  Feature: The user is trying the WishList Functionality


    Scenario: Adding product to the wishList and get alert msg
      When the user clicks on the wishList button of a product
      Then adding to the wishList should display an alert and be successful




     Scenario: The WishList counter is getting changed after adding a product to the wishList
       When the user clicks on the wishList button of a product
        And    Wait until the alert disappear Then click on the wishlist tab at the header
        Then   the wishList counter should be changed after adding the product to it