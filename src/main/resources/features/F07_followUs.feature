@regression
  Feature: Follow us Functionality


    Scenario: the user clicks on facebook social media icon
      Given the user clicks on facebook Icon
      Then  the user should redirected to the facebook page "http://www.facebook.com/nopCommerce"



    Scenario: the user clicks on twitter social media icon
      Given the user clicks on twitter Icon
      Then  the user should redirected to the twitter page "https://twitter.com/nopCommerce"



    Scenario: the user clicks on rss social media icon
      Given the user clicks on rss Icon
      Then  the user should redirected to the rss page "https://demo.nopcommerce.com/new-online-store-is-open"



    Scenario: the user clicks on youtube social media icon
      Given the user clicks on youtube Icon
      Then  the user should redirected to the youtube page "https://www.youtube.com/user/nopCommerce"