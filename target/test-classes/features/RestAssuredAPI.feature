#Author: Sunith M
#Keywords Summary : restassured endpoint response validations
#Feature: restassured endpoint response validations 

@Restassured
Feature: restassured endpoint response validation
  
  @Restassured01
  Scenario: verify response code, body and header
    Given launch the endpoint url for response
    And launch the endpoint url using static imports