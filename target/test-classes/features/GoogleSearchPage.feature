#Author: Sunith M
#Keywords Summary : Google search page feature
#Feature: Google search scenarios 

@Google
Feature: Google search page
  
  @Google01
  Scenario: Google search for text Selenium Testing
    Given launch the browser with application portal
    And  enter the text and search for it
    When select value in the search area
    And  open the serch page and check the "Selenium Testing - Google Search" title 
    Then close the browser
