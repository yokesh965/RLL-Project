Feature: Add a new service type in manage appointment page

@New_Service_Type
Scenario: Add a New Service Type
  	Given I am on the OpenMRS login page
    When I enter valid login credentials
    And I click the login button
    And I click on Appointment Scheduling
    And I click on Manage Service Types
    And I click on New Service Type
    And I fill in the necessary information for a new service type
    And I click the Save button
    Then I should see a success message for adding the new service type