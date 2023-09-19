Feature: OpenMRS Patient Record Search

@SearchPatient
 Scenario: Navigate to OpenMRS and Perform Patient Record Search
    Given I am on the OpenMRS login page
    When I enter my username and password 
    And I click the Login button
    And I click on the Find Patient Record
    Then I enters an multiple patient name  "<patient name or id>" in the search text-box
    
Examples:
    |patient name or id|
    |Helen Allen|
    |John Green|
    |sri|
    |nike|
    
    
    
    
    
    
    
    
 
    