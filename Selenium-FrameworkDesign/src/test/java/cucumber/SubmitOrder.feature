@tag
Feature: Submit order from Ecommerce Website
  I want to use this template for my feature file
  
  Background: 
  Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with <username> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | username			| password 		| productName |
      | chuy@bah.com 	| Hello1234! 	| ZARA COAT 3 |
 
