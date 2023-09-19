Feature: Find Patient Record

 Background:
    Given I am on the application login page
    
@Register
 Scenario: Search Patient Record by Name
    When I log in with valid credentials
    And I click on Register a Patient
    And I Enter the Patient Details <RowNumber>
    And I click the Confirm button 
    And I click the Search button
    Then I should see the Find patient record details
Examples:
|RowNumber|
|1|
|2|
|3|