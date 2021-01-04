Feature: Flipkart Scenario

  @Test1
  Scenario: Get List of Samsung mobiles from Flipkart
    Given I navigate to "flipkart" from "chrome" browser
    When I search for the product "Samsung Galaxy S10" 
    And I click on filters 
    Then I export all links in list 
    
      @Test2
  Scenario: Get List of Samsung mobiles from Flipkart
    Given I navigate to "flipkart" from "firefox" browser
    When I search for the product "Samsung Galaxy S10" 
    And I click on filters 
    Then I export all links in list 
    