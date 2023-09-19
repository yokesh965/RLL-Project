Feature: Create Appointment Block

@TS_07
Scenario: User must be able to create appointment block
Given a user is on the landing page of Openmrs
When a user enters the username and password details
And user selects the Inpatient Ward Location
And user clicks on the log in button
Then he must see the message - "Logged in as Super User (admin) at Inpatient Ward."
And user clicks on the Appointment Scheduling
And user clicks on the Manage Provider Schedules
Then user must see the message - "Manage Appointment Blocks"
And user selects the date for the calendar
And user selects user from the Provider list
And user enters service type from the services box
And user clicks on save
Then he must see the error message - "Can't save because the selected provider is already scheduled at this time."
And user clicks on cancel
And user clicks on created block and clicks on edit
Then he must verify the message - "Edit Appointment Block"
And user selects required service
And user clicks on save button
Then he must see the final message - "Manage Appointment Blocks".
