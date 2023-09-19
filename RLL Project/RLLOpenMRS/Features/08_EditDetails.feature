Feature: Edit Registration Details

@Edit_Patient
Scenario: a user is be able to edit the registration details of patient with only valid data
Given a user is on the landing page
When he enters the login credentials and click on login
And  he click on find patient record
And  he enters the search id or name of patient
And  he click on which patient data want to edit
And he click on edit Registration details
And  he click on name to edit the name in  registration
Then verify the test whether the data is edited or not